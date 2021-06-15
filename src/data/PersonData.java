package data;

import entities.Person;
import services.AdministratorsService;
import services.AttendantsService;

import static infrastructure.Cryptography.decode;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

public class PersonData {

    public void insertPerson( Person p) throws SQLException, IOException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();

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
             "    CARGO_AREA_PUBLICA, \n" +
             "    ID_PERFIL,\n" +
             "    NIVEL_DE_PRIORIDADE\n" +
             ")VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

        PreparedStatement stm = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        stm.setString(1,p.cpf);
        stm.setString(2,p.name);
        stm.setInt(3,p.age);
        stm.setString(4,p.email);
        stm.setString(5,p.password);
        stm.setString(6, p.address);
        stm.setInt(7, p.addressNumber);
        stm.setString(8, p.state);
        stm.setString(9,p.city);
        stm.setString(10,p.district);
        stm.setInt(11,p.cep);
        stm.setBoolean(12, p.healthPosition);
        stm.setInt(13,p.profileId);
        stm.setInt(14,p.priority);

        stm.execute();
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
        int perfil =0;
        int age;

        Object[] remove =
                { "Sim",
                    "Não"
                };

        String titleMessage = "Realmente Deseja Remover este usuario?";

        String pessoa ="";

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();

        PreparedStatement stm = connection.prepareStatement("SELECT p.*,pf.descricao FROM PEOPLE p INNER JOIN PERSON_PROFILE pf ON pf.id = p.ID_PERFIL WHERE p.cpf = ?;");
        stm.setString(1,cpfRequested);
        stm.execute();
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
        if(perfil==3){
            JOptionPane.showMessageDialog(null, "Você não pode remover um paciente");
            return;
        }

        int confirm = JOptionPane.showOptionDialog(null, pessoa, titleMessage, JOptionPane.
                DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, remove, remove[0]);

        if(confirm == 1){
            JOptionPane.showMessageDialog(null,"Cancelando");
            connection.close();
            return;
            }
        PreparedStatement rmv = connection.prepareStatement("DELETE FROM PEOPLE WHERE CPF = ?");
        rmv.setString(1,cpfRequested);
        rmv.execute();

        int linhasModificadas = rmv.getUpdateCount();
        if(linhasModificadas>0){
            JOptionPane.showMessageDialog(null,"Remoção Concluida");
            connection.close();
        }
    }

    public void updatePassword(String email, String newPassword) throws SQLException, IOException{
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();


        PreparedStatement stm = connection.prepareStatement("UPDATE PEOPLE SET PASSWORD = ? WHERE EMAIL = ?;");
        stm.setString(1,newPassword);
        stm.setString(2,email);

        stm.execute();
        int modifiedLines = stm.getUpdateCount();
            if (modifiedLines>0){
                JOptionPane.showMessageDialog(null, "sucesso");
        }
        connection.close();

    }

    public double[] report(LocalDate startDate, LocalDate endDate) throws SQLException, IOException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();

        PreparedStatement stm = connection.prepareStatement("SELECT IDADE FROM PEOPLE WHERE DATA_DE_VACINACAO BETWEEN ? AND ? ORDER BY DATA_DE_VACINACAO;");
        stm.setDate(1, Date.valueOf(startDate));
        stm.setDate(2, Date.valueOf(endDate));
        stm.execute();

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

    public int loginAutentication(String cpf, String password){
        int perfilId = 0;
        try {
            ConnectionFactory connectionFactory = new ConnectionFactory();
            Connection connection = connectionFactory.getConnection();


            Statement stm = connection.createStatement();
            stm.execute("SELECT * FROM PEOPLE WHERE CPF = '"+cpf+"';");
            ResultSet rst = stm.getResultSet();
            String dbPassoword = "";

            while (rst.next()){
                dbPassoword = decode(rst.getString("PASSWORD"));
                perfilId = rst.getInt("ID_PERFIL");
            }

            if(password.equals(dbPassoword)){
                connection.close();
                return perfilId;
            }
            connection.close();
            return 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }
}

