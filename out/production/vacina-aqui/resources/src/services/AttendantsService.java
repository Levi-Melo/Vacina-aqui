package services;

import data.ConnectionFactory;
import entities.Person;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class AttendantsService {
    String titleMessage = "Escolha a opção desejada";

    Object[] options =
            { "Ver Fila",
                    "Confirmar vacinação",
                    "Cancelar"
            };

    public Object[][] consultQueue() throws SQLException, IOException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();

        PreparedStatement stm = connection.prepareStatement("SELECT * FROM PEOPLE;");
        stm.execute();

        ResultSet rst = stm.getResultSet();
        ArrayList<Person> fila = new ArrayList<>();
        while (rst.next()){
            int id = rst.getInt("ID");
            String cpf = rst.getString("CPF");
            String name = rst.getString("NOME");
            int age = rst.getInt("IDADE");
            String state = rst.getString("ESTADO");
            String city = rst.getString("CIDADE");
            int priority = rst.getInt("NIVEL_DE_PRIORIDADE");
            fila.add(new Person(id ,name, cpf, age, state , city ,priority));
        }
        Object dados [][] = new Object[fila.size()][7];
        for(int i = 0; i<fila.size(); i++){
            dados[i][0] = fila.get(i).id;
            dados[i][1] = fila.get(i).name;
            dados[i][2] = fila.get(i).cpf;
            dados[i][3] = fila.get(i).age;
            dados[i][4] = fila.get(i).city;
            dados[i][5] = fila.get(i).state;
            dados[i][6] = fila.get(i).priority;
        }
    return dados;
    }

    public void vaccineConfirm() throws SQLException, IOException {
        LocalDate date = LocalDate.now();

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();

        PreparedStatement stm = connection.prepareStatement("UPDATE PEOPLE \n" +
                "SET DATA_DE_VACINACAO = ? \n" +
                "WHERE ID_PERFIL = 3 AND DATA_DE_VACINACAO IS NULL order by NIVEL_DE_PRIORIDADE " +
                "LIMIT 1;");
        stm.setDate(1,Date.valueOf(date));
        stm.executeUpdate();
    }
}
