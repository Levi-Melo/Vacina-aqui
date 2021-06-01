package entities;
import domains.Password;

import javax.swing.*;
import java.io.IOException;


public class Person {
    public String name;
    public String cpf;
    public int age;
    public String email;
    public String password;
    public String address;
    public int addressNumber;
    public String state;
    public String city;
    public String district;
    public int cep;
    public int profileId;
    public boolean healthPosition;
    public int priority;

    Person(String name,String cpf,int age,String email,String password, String address,
           int addressNumber, String state, String city, String district, int cep,
           int profileId, boolean healthPosition, int priority){

        this.name = name;
        this.cpf = cpf;
        this.age = age;
        this.email = email;
        this.password = password;
        this.address = address;
        this.addressNumber = addressNumber;
        this.state = state;
        this.city = city;
        this.district = district;
        this.cep = cep;
        this.profileId = profileId;
        this.healthPosition = healthPosition;
        this.priority = priority;

    }

    public static Person createPerson(int id) throws IOException {

        String optionDialogMessage = "O paciente trabalha na área da saúde?";
        String titleMessage = "Escolha a opção desejada";


        Object[] confirm =
                { "Sim",
                        "Não"
                };
        Password pwd = new Password();

        String name = JOptionPane.showInputDialog(null, "Digite seu CPF sem caracteres especiais");
        String cpf = JOptionPane.showInputDialog(null, "Digite seu nome");
        int age = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite sua idade"));
        String email =  JOptionPane.showInputDialog(null, "Digite seu email");
        String password = pwd.createPassword(email);
        String address = JOptionPane.showInputDialog(null, "Digite seu Endereço");
        int addressNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero do Endereço"));
        String state = JOptionPane.showInputDialog(null, "Digite o estado em que mora");
        String city = JOptionPane.showInputDialog(null, "Digite a cidade em que mora");
        String district = JOptionPane.showInputDialog(null, "Digite o bairro em que mora");
        int cep = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite seu cep apenas com numeros"));
        boolean healthPosition = false;
        int priority = 3;

        if (id == 3){
            //paciente
            healthPosition = getBoolean(JOptionPane.showOptionDialog(null, optionDialogMessage,
                    titleMessage, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, confirm, confirm[0]));
        }
        if(healthPosition){
                priority = 2;
            }
            if(age>=70){
                priority = 1;
            }
        return new Person(name, cpf, age, email, password, address, addressNumber, state, city, district, cep, id, healthPosition, priority);

    }

    static Boolean getBoolean(int number){ return number == 0; }
}

