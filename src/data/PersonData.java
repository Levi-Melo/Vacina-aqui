package data;

import entities.Person;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

public class PersonData {

    public void insertPerson(Person p) throws SQLException, IOException {
        String sql;
        sql = "INSERT INTO PEOPLE(\n" +
             "    CPF,\n" +
             "    NOME,\n" +
             "    IDADE,\n" +
             "    EMAIL,\n" +
             "    PASSWORD,\n" +
             "    ENDERECO,\n" +
             "    NUMERO,\n" +
             "    ESTADO,\n" +
             "    CIDADE ,\n" +
             "    BAIRRO,\n" +
             "    CEP,\n" +
             "    DATA_DE_VACINACAO,\n" +
             "    CARGO_AREA_PUBLICA, \n" +
             "    ID_PERFIL,\n" +
             "    NIVEL_DE_PRIORIDADE\n" +
             ")VALUES('" + p.cpf + "'," +
                "'" + p.name + "'," +
                "" + p.age + "," +
                "'" + p.email + "'," +
                "'" + p.password + "'," +
                "'" + p.address + "'," +
                "'" + p.addressNumber + "'," +
                "'" + p.state + "'," +
                "'" + p.district + "'," +
                "'" + p.cep + "'," +
                "null," +
                "" + p.healthPosition + "," +
                "" + p.profileId + "," +
                ""+p.priority+");";

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();

        Statement stm = connection.createStatement();
        stm.execute(sql,Statement.RETURN_GENERATED_KEYS);

        ResultSet rst = stm.getGeneratedKeys();

        while (rst.next()){
            int id = rst.getInt(1);
            if(id > 0){
                JOptionPane.showMessageDialog(null,"Cadastro Concluido");
            }
        }
            connection.close();
    }

    public void removePerson (String cpfRequested) throws SQLException, IOException{
        String cpf;
        String email;
        String name;
        int age;

        Object[] remove =
                { "Sim",
                    "Não"
                };

        String titleMessage = "Realmente Deseja Remover este usuario?";

        String pessoa ="";

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();

        Statement stm = connection.createStatement();
        stm.execute("USE  PROJETO_COVID;\n" +
                "SELECT \n" +
                "\tp.*,\n" +
                "\tpf.descricao\n" +
                "FROM PEOPLE p INNER JOIN PERSON_PROFILE pf ON pf.id = p.ID_PERFIL WHERE p.cpf = '"+cpfRequested+"';");
        ResultSet rst = stm.getResultSet();

        while (rst.next()){
             cpf = rst.getString("CPF");
             name = rst.getString("NOME");
             age = rst.getInt("IDADE");
             email = rst.getString("EMAIL");
             String perfilprofile = rst.getString("DESCRICAO");
             pessoa =  name + "\n "+ perfilprofile+"\n " + email + "\n" + cpf +" \n"+ age ;
        }

        int confirm = JOptionPane.showOptionDialog(null, pessoa, titleMessage, JOptionPane.
                DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, remove, remove[0]);
        if(confirm == 1){
            JOptionPane.showMessageDialog(null,"Cancelando");
            connection.close();
            return;
            }
        stm.execute("DELETE FROM PEOPLE WHERE CPF = '" + cpfRequested + "'");
        int linhasModificadas = stm.getUpdateCount();
        if(linhasModificadas>0){
            JOptionPane.showMessageDialog(null,"Remoção Concluida");
            connection.close();
        }

    }

    public void personLogin(String login) {
        String password = "";
        int perfilPage = 0;
        try {
            ConnectionFactory connectionFactory = new ConnectionFactory();
            Connection connection = connectionFactory.getConnection();

            Statement stm = connection.createStatement();
            stm.execute("SELECT * FROM PEOPLE WHERE CPF = '"+login+"';");

            ResultSet rst = stm.getResultSet();
            String newPassword = JOptionPane.showInputDialog(null,"Digite a sua  senha");
            while (rst.next()){
                password = rst.getString("PASSWORD");
                perfilPage = rst.getInt("ID_PERFIL");
            }

            if(password.equals(newPassword)){
                //abrir a pagina do usuario de acordo com perfilPage
                JOptionPane.showMessageDialog(null, "sucesso");
            }
            if(perfilPage == 1){
                //retorna pagina de acordo com o perfil
                connection.close();
                return;
            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void updatePassword(String email, String newPassword) throws SQLException, IOException{
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();


        Statement stm = connection.createStatement();
        stm.execute("UPDATE PEOPLE\n" +
                "SET PASSWORD = "+newPassword+"\n" +
                "WHERE EMAIL = '"+email+"';");
        int modifiedLines = stm.getUpdateCount();

        ResultSet rst = stm.getGeneratedKeys();
        while (rst.next()){
            if (modifiedLines>0){
                JOptionPane.showMessageDialog(null, "sucesso");
            }
        }
        connection.close();

    }

    public double[] report(LocalDate data1, LocalDate data2) throws SQLException, IOException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();

        Statement stm = connection.createStatement();
        stm.execute("SELECT IDADE FROM PEOPLE WHERE DATA_DE_VACINACAO BETWEEN "+data1+" AND "+data2+" ORDER BY DATA_DE_VACINACAO;");

        ResultSet rst = stm.getResultSet();
        double[] vacinForAgeRange = new double[4];

        while (rst.next()) {
            int age = rst.getInt("IDADE");

            if(age>=90){
                vacinForAgeRange[0] += 1;
            }
            if(70<=age && age<90){
                vacinForAgeRange[1] += 1;
            }
            if(50<=age && age<70) {
                vacinForAgeRange[2] += 1;
            }
            if (age < 50){
                vacinForAgeRange[3] += 1;
            }

        }
        connection.close();
        return vacinForAgeRange;
    }

}

