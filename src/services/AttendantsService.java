package services;

import data.ConnectionFactory;
import data.PersonData;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AttendantsService {
    void confirmationOfVaccine() throws SQLException {
        PersonData vacin = new PersonData();

        String cpf = JOptionPane.showInputDialog("informe o cpf do paciente");
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dataFormatada = sdf.format(data);
        vacin.vacineDate(dataFormatada ,cpf);

    }

    public void consultQueue()throws SQLException {

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
