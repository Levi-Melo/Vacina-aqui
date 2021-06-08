import data.ConnectionFactory;

import static infrastructure.GetProperties.getPropertie;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.Properties;


public class Teste {
    public static void main(String[] args) throws SQLException, IOException {
        try{

        LocalDate date = LocalDate.now();

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();

        PreparedStatement stm = connection.prepareStatement("UPDATE PEOPLE \n" +
                "SET DATA_DE_VACINACAO = ? \n" +
                "WHERE ID_PERFIL = 3 order by NIVEL_DE_PRIORIDADE " +
                "LIMIT 1;");
            stm.setDate(1,Date.valueOf(date));
            stm.executeUpdate();

        }catch (Exception e){
            System.out.println(e);
        }
    }
}