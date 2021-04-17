package entities;

import data.PersonData;
import domains.Password;
import org.jetbrains.annotations.NotNull;
import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class Person {
    public String name;
    public String cpf;
    public int age;
    public String email;
    public String password;
    public String address;
    public int profileId;
    public boolean healthPosition;
    public int priority;


    String optionDialogMessage = "O paciente trabalha na área da saúde?";
    String titleMessage = "Escolha a opção desejada";


    public void createPerson(int profileId, @NotNull Person p) throws SQLException, IOException {

        Object[] confirm =
                { "Sim",
                        "Não"
                };

        p.cpf = JOptionPane.showInputDialog(null, "Digite seu CPF sem caracteres especiais");
        p.name = JOptionPane.showInputDialog(null, "Digite seu nome");
        p.age = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite sua idade"));
        p.email = JOptionPane.showInputDialog(null, "Digite seu email");
        p.address = JOptionPane.showInputDialog(null, "Digite seu Endereço");
        p.profileId = profileId;
        p.priority = 3;

        Password pwd = new Password();
        p.password = pwd.createPassword(p.email);
        PersonData insert = new PersonData();

        if (profileId == 3){
            //paciente
            p.healthPosition = getBoolean(JOptionPane.showOptionDialog(null, optionDialogMessage,
                    titleMessage, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, confirm, confirm[0]));
            if(p.healthPosition){
                p.priority = 2;
            }
            if(p.age>=70){
                p.priority = 1;
            }
            insert.insertPerson(p);
            return;
        }
        insert.insertPerson(p);
    }

    Boolean getBoolean(int number){ return number == 0; }
}

