package services;
import javax.swing.*;
import data.PersonData;
import entities.Person;

import java.util.Calendar;


public class AdministratorsService{

    String titleMessage = "Escolha a opção desejada";

    Object[] registerOptions =
            { "Adiministrador",
                    "Atendente",
                    "Paciente",
                    "Cancelar"
            };

    Object[] remove =
            { "Sim",
                "Não"
            };

    public void register ()  {
        String optionDialogMessage = "deseja cadastrar um Paciente, Administrador ou Atendente?";
        int option = JOptionPane.showOptionDialog(null, optionDialogMessage, titleMessage, JOptionPane.
                DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, registerOptions, registerOptions[0]);
        if (option == 3 ){
            JOptionPane.showMessageDialog(null, "Cancelando");
            return;
        }
        Person person = new Person();
        int charge = option + 1 ;
        try {
            person.createPerson(charge,person);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void remove () {
        String optionDialogMessage = "deseja remover um Administrador ou Atendente?";
        int option = JOptionPane.showOptionDialog(null, optionDialogMessage, titleMessage, JOptionPane.
                DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, remove, remove[0]);
        if (option == 1 ){
            JOptionPane.showMessageDialog(null, "Cancelando");
            return;
        }
        Person person = new Person();
        try {
            person.cpf = JOptionPane.showInputDialog(null, "Digite seu CPF sem caracteres especiais");
            PersonData rmv = new PersonData();
            rmv.removePerson(person);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    void generateReport(){
        try {
            int dia = 16;
            int mes = 4;
            int ano = 2021;
            String end = ano+""+mes+""+dia;

            Calendar a = Calendar.getInstance();
            a.set(ano, mes, dia);//data maior

            dia = 16;
            mes = 4;
            ano = 2020;
            String start = ano+""+mes+""+dia;

            Calendar b = Calendar.getInstance();
            b.set(2020, 4, 15);// data menor

            a.add(Calendar.DATE, - b.get(Calendar.DAY_OF_YEAR));
            int quantidadeDeDias = a.get(Calendar.DAY_OF_YEAR);

            PersonData report = new PersonData();
            int[] vacinForAgeRange = report.report(start,end);
            int[] medias = new int[4];

            for (int i=0;i<vacinForAgeRange.length;i++){
                medias[i] = vacinForAgeRange[i]/quantidadeDeDias;
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
