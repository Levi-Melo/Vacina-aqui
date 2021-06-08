package services;

import data.ConnectionFactory;
import entities.Person;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

public class AttendantsService {
    String titleMessage = "Escolha a opção desejada";

    Object[] options =
            { "Ver Fila",
                    "Confirmar vacinação",
                    "Cancelar"
            };

    public void attendantsActions() throws SQLException, IOException {
        String optionDialogMessage = "deseja ver a fila de vacinação, confirmar vacinação?";
        int option = JOptionPane.showOptionDialog(null, optionDialogMessage, titleMessage, JOptionPane.
                DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        System.out.println(option);

        switch (option){
            case 0:
                this.consultQueue();
                this.attendantsActions();
                break;
            case 1:
                this.vaccineConfirm();
                this.attendantsActions();
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "cancelando");
                break;
        }
        return;
    }

    public void consultQueue() throws SQLException, IOException {
        String optionDialogMessage = "Desejava vacinar o primeiro paciente da fila?";
        String titleMessage = "Escolha a opção desejada";

        Object[] confirm =
                { "Sim",
                        "Não"
                };

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();

        PreparedStatement stm = connection.prepareStatement("SELECT * FROM PEOPLE WHERE ID_PERFIL = 3 AND DATA_DE_VACINACAO = null order by NIVEL_DE_PRIORIDADE LIMIT 1;");
        stm.execute();

        ResultSet rst = stm.getResultSet();
        String[] fila = new String[10];
        int index = 0;
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
            fila[index] = id + " " + name + " " + cpf +" "+ age + " " + email +" " + address +" " + addressNumber +
                    " " + state+ " " + district +" " + cep +" " + city +" " + data +" " + healthPosition+ " " +priority;
            index++;
        }
        JOptionPane.showMessageDialog(null,
                fila[0]+"\n"+
                        fila[1]+"\n"+
                        fila[2]+"\n"+
                        fila[3]+"\n"+
                        fila[4]+"\n"+
                        fila[5]+"\n"+
                        fila[6]+"\n"+
                        fila[7]+"\n"+
                        fila[8]+"\n"+
                        fila[9]+"\n");

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

        PreparedStatement stm = connection.prepareStatement("UPDATE PEOPLE \n" +
                "SET DATA_DE_VACINACAO = ? \n" +
                "WHERE ID_PERFIL = 3 order by NIVEL_DE_PRIORIDADE " +
                "LIMIT 1;");
        stm.setDate(1,Date.valueOf(date));
        stm.executeUpdate();
        this.attendantsActions();
    }
}
