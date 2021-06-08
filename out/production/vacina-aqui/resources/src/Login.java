import data.ConnectionFactory;
import services.AdministratorsService;
import services.AttendantsService;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static infrastructure.Cryptography.decode;

public class Login {
    public static void main(String[] args) {
        int perfilPage = 0;
        try {
            ConnectionFactory connectionFactory = new ConnectionFactory();
            Connection connection = connectionFactory.getConnection();

            String cpf = JOptionPane.showInputDialog(null, "Digite seu CPF para ter acesso ao sistema");
            String password =  JOptionPane.showInputDialog(null, "Digite sua senha");

            Statement stm = connection.createStatement();
            stm.execute("SELECT * FROM PEOPLE WHERE CPF = '"+cpf+"';");

            ResultSet rst = stm.getResultSet();
            String dbPassoword = "";

            while (rst.next()){
                dbPassoword = decode(rst.getString("PASSWORD"));
                perfilPage = rst.getInt("ID_PERFIL");
            }

            if(password.equals(dbPassoword)){
                //abrir a pagina do usuario de acordo com perfilPage
                JOptionPane.showMessageDialog(null, "sucesso");
                if(perfilPage == 1){
                    //retorna pagina de acordo com o perfil
                    AdministratorsService admOptions = new AdministratorsService();
                    admOptions.administratorsActions();
                    connection.close();
                    return;
                }
                //retorna pagina de acordo com o perfil
                AttendantsService attOptions = new AttendantsService();
                attOptions.attendantsActions();
            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
