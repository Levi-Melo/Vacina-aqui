package services;

import data.ConnectionFactory;
import data.PersonData;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class AttendantsService {
    public void confirmationOfVaccine() throws SQLException, IOException {
        LocalDate date = LocalDate.now();

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConection();

        Statement stm = connection.createStatement();
        stm.execute("SELECT * FROM PEOPLE WHERE ID_PERFIL = 3 order by NIVEL_DE_PRIORIDADE;");

        ResultSet rst = stm.getResultSet();
        rst.absolute(1);
        rst.updateString("DATA_DE_VACINACAO", String.valueOf(date));

        PersonData vacin = new PersonData();
        String cpf = JOptionPane.showInputDialog("informe o cpf do paciente");

        vacin.vacineDate(date, cpf);
    }

    public void consultQueue() throws SQLException, IOException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConection();

        Statement stm = connection.createStatement();
        stm.execute("SELECT * FROM PEOPLE WHERE ID_PERFIL = 3 order by NIVEL_DE_PRIORIDADE;");

        ResultSet rst = stm.getResultSet();

        System.out.println(rst);
        while (rst.next()){
            int id = rst.getInt("ID");
            String cpf = rst.getString("CPF");
            String name = rst.getString("NOME");
            int age = rst.getInt("IDADE");
            String email = rst.getString("EMAIL");
            String address = rst.getString("ENDERECO");
            String data = rst.getString("DATA_DE_VACINACAO");
            boolean healthPosition = rst.getBoolean("CARGO_AREA_PUBLICA");
            int priority = rst.getInt("NIVEL_DE_PRIORIDADE");
            System.out.println(id + " " + name + " " + cpf +" "+ age + " " + email +" " + address + " " + data +" " + healthPosition+ " " +priority);
        }
        connection.close();
    }
}
