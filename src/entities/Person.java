package entities;

import data.PersonData;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
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


    public void createPerson(int profileId, @NotNull Person p) throws SQLException {

        Object[] confirm =
                { "Sim",
                        "Não"
                };

        p.cpf = JOptionPane.showInputDialog(null, "Digite seu CPF sem caracteres especiais");
        p.name = JOptionPane.showInputDialog(null, "Digite seu nome");
        p.age = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite sua idade"));
        p.email = JOptionPane.showInputDialog(null, "Digite seu email");
        p.address = JOptionPane.showInputDialog(null, "Digite seu Endereço");
        p.password = createPassword();
        p.profileId = profileId;
        p.priority = 3;


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
            PersonData insr = new PersonData();
            insr.insertPerson(p);
            return;
        }
        PersonData insr = new PersonData();
        insr.insertPerson(p);
    }

    private String createPassword(){
        String randomPassword = "";
        for (int j = 0; j <2; j++) {
            randomPassword += randomNumber();
            randomPassword += randomCharacter();

        }
        for (int j = 0; j < 2; j++) {
            randomPassword += randomCharacter();
            randomPassword += randomNumber();

        }
        System.out.println(randomPassword);
        return randomPassword;
    }

    public static char randomCharacter() {

        int rand = (int) (Math.random() * 62);
        if (rand <= 35) {
            int uppercase = rand + 55;
            return (char) (uppercase);
        } else {
            int lowercase = rand + 61;
            return (char) (lowercase);
        }
    }

    public static char randomNumber() {
        int rand = (int) (Math.random() * 62);

        if (rand <= 9) {
            int number = rand + 48;
            return (char) (number);
        } else {
            return randomNumber();
        }
    }

    Boolean getBoolean(int number){ return number == 0; }
}

