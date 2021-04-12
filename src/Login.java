import javax.swing.*;

import data.PersonData;

import java.sql.SQLException;



public class Login extends PersonData {
    public static void main(String[] args) throws SQLException {
        PersonData p = new PersonData();
        String login = JOptionPane.showInputDialog(null,"Digite a seu cpf para login");
        p.personLogin(login);
    }
}
