package services;

import data.ConnectionFactory;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

public class AttendantsService {

    public void consultQueue() throws SQLException, IOException {
        String optionDialogMessage = "Desejava vacinar o primeiro paciente da fila?";
        String titleMessage = "Escolha a opção desejada";

        Object[] confirm =
                { "Sim",
                        "Não"
                };

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();

        PreparedStatement stm = connection.prepareStatement("SELECT * FROM PEOPLE WHERE ID_PERFIL = 3 order by NIVEL_DE_PRIORIDADE;");
        stm.execute();

        ResultSet rst = stm.getResultSet();

        System.out.println(rst);
        while (rst.next()){
            int id = rst.getInt("ID");
            String cpf = rst.getString("CPF");
            String name = rst.getString("NOME");
            int age = rst.getInt("IDADE");
            String email = rst.getString("EMAIL");
            String address = rst.getString("ENDERECO");
            String addressNumber = rst.getString("NUMERO");
            String state = rst.getString("ESTADO");
            String city = rst.getString("CIDADE");
            String district = rst.getString("BAIRRO");
            int cep = rst.getInt("CEP");
            String data = rst.getString("DATA_DE_VACINACAO");
            boolean healthPosition = rst.getBoolean("CARGO_AREA_PUBLICA");
            int priority = rst.getInt("NIVEL_DE_PRIORIDADE");
            System.out.println(id + " " + name + " " + cpf +" "+ age + " " + email +" " + address +" " + addressNumber +
                    " " + state+ " " + district +" " + cep +" " + city +" " + data +" " + healthPosition+ " " +priority);
        }
        int option = JOptionPane.showOptionDialog(null, optionDialogMessage, titleMessage,
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, confirm, confirm[0]);

        if (option==0){
            vaccineConfirm();
        }
        connection.close();
    }

    public void vaccineConfirm() throws SQLException, IOException {

        LocalDate date = LocalDate.now();

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();

        PreparedStatement stm = connection.prepareStatement("SELECT * FROM PEOPLE WHERE ID_PERFIL = 3 order by NIVEL_DE_PRIORIDADE;");
        stm.execute();

        ResultSet rst = stm.getResultSet();
        rst.absolute(1);
        rst.updateDate("DATA_DE_VACINACAO", Date.valueOf(date));
    }
}
