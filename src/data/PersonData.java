package data;

import entities.Person;

import javax.swing.*;
import java.sql.*;

public class PersonData {
    public void insertPerson(Person p) throws SQLException {
        String sql;
        if (p.profileId == 3) {
             sql = "INSERT INTO PEOPLE(\n" +
                    "CPF,\n" +
                    "NOME,\n" +
                    "IDADE,\n" +
                    "ENDERECO,\n" +
                    "CARGO_AREA_PUBLICA,\n" +
                    "ID_PERFIL,\n" +
                    "NIVEL_DE_PRIORIDADE\n" +
                    ")VALUES('" + p.cpf + "','" + p.name + "'," + p.age + ",'" + p.address + "'," + p.healthPosition + "," + p.profileId + "," +p.priority+");";
        }else {
             sql = "INSERT INTO PEOPLE(\n" +
                    "CPF,\n" +
                    "NOME,\n" +
                    "IDADE,\n" +
                    "EMAIL,\n" +
                    "PASSWORD,\n" +
                    "ENDERECO,\n" +
                    "ID_PERFIL\n" +
                    ")VALUES('" + p.cpf + "','" + p.name + "'," + p.age + ",'" + p.email + "','" + p.password + "','" + p.address + "'," + p.profileId + ");";
        }

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConection();

        Statement stm = connection.createStatement();
        stm.execute(sql,Statement.RETURN_GENERATED_KEYS);

        ResultSet rst = stm.getGeneratedKeys();

        while (rst.next()){
            Integer id = rst.getInt(1);
            if(id > 0){
                JOptionPane.showMessageDialog(null,"Cadastro Concluido");
            }
        }
            connection.close();
    }

    public void removePerson (Person p) throws SQLException{
        String cpf = "";
        String email = "";
        String name = "";
        int age = 0;
        int perfil = 0 ;

        Object[] remove =
                { "Sim",
                    "Não"
                };

        String titleMessage = "Realmente Deseja Remover este usuario?";

        String pessoa ="";
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConection();

        Statement stm = connection.createStatement();
        stm.execute("USE  PROJETO_COVID;\n" +
                "SELECT \n" +
                "\tp.*,\n" +
                "\tpf.descricao\n" +
                "FROM PEOPLE p INNER JOIN PERSON_PROFILE pf ON pf.id = p.ID_PERFIL WHERE p.cpf = '"+p.cpf+"';");
        ResultSet rst = stm.getResultSet();

        while (rst.next()){
             cpf = rst.getString("CPF");
             name = rst.getString("NOME");
             age = rst.getInt("IDADE");
             email = rst.getString("EMAIL");
             perfil = rst.getInt("ID_PERFIL");
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
        stm.execute("DELETE FROM PEOPLE WHERE CPF = '" + p.cpf + "'");
        Integer linhasModificadas = stm.getUpdateCount();
        if(linhasModificadas>0){
            JOptionPane.showMessageDialog(null,"Remoção Concluida");
            connection.close();
            return;
        }

    }

    public void personLogin(String login) throws SQLException{
        String password = "";
        int perfilPage = 0;
        try {
            ConnectionFactory connectionFactory = new ConnectionFactory();
            Connection connection = connectionFactory.getConection();

            Statement stm = connection.createStatement();
            stm.execute("SELECT * FROM PEOPLE WHERE CPF = '"+login+"';");

            ResultSet rst = stm.getResultSet();
            String senha = JOptionPane.showInputDialog(null,"Digite a sua  senha");
            while (rst.next()){
                password = rst.getString("PASSWORD");
                perfilPage = rst.getInt("ID_PERFIL");
            }

            if(password.equals(senha)){
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
        };
    }

    public void vacineDate(String date, String cpf) throws SQLException{
        Date dataModificada;

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConection();

        Statement stm = connection.createStatement();
        stm.execute("UPDATE PEOPLE\n" +
                "SET DATA_DE_VACINACAO = "+date+"\n" +
                "WHERE CPF = '"+cpf+"';");
        Integer linhasModificadas = stm.getUpdateCount();
        stm.execute("SELECT DATA_DE_VACINACAO FROM PEOPLE WHERE CPF= '"+cpf+"';");
        ResultSet rst = stm.getResultSet();
        while (rst.next()){
            dataModificada = rst.getDate("DATA_DE_VACINACAO");
            if (linhasModificadas>0){
                JOptionPane.showMessageDialog(null, "sucesso");
            }
        }
        connection.close();

    }

}
