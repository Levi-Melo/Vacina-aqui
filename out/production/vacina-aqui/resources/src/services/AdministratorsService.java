package services;
import javax.swing.*;
import data.PersonData;
import entities.Person;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        String date1 = JOptionPane.showInputDialog(null, "digite a data Inicial do seu relatorio(dd/mm/aaaa)");
        String date2 = JOptionPane.showInputDialog(null, "digite a data Final do seu relatorio(dd/mm/aaaa)");

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate start = LocalDate.parse(date1, formato);
        LocalDate end = LocalDate.parse(date2, formato);

        Duration diff = Duration.between(start.atStartOfDay(), end.atStartOfDay());
        long diffDays = diff.toDays();
        try {

            PersonData report = new PersonData();
            long[] vacinForAgeRange = report.report(start,end);
            long[] medias = new long[4];

            for (int i=0;i<vacinForAgeRange.length;i++){
                medias[i] = vacinForAgeRange[i]/diffDays;
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
