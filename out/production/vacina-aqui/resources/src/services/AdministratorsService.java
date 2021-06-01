package services;
import javax.swing.*;
import data.PersonData;
import entities.Person;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static entities.Person.createPerson;


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
        int charge = option + 1 ;
        try {
            Person person = createPerson(charge);
            PersonData insert = new PersonData();
            insert.insertPerson(person);
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

        try {
            String cpf = JOptionPane.showInputDialog(null, "Digite seu CPF sem caracteres especiais");
            PersonData rmv = new PersonData();
            rmv.removePerson(cpf);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    void reportGenerator(){
        String date1 = JOptionPane.showInputDialog(null, "digite a data Inicial do seu relatorio(dd/mm/aaaa)");
        String date2 = JOptionPane.showInputDialog(null, "digite a data Final do seu relatorio(dd/mm/aaaa)");

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate start = LocalDate.parse(date1, formato);
        LocalDate end = LocalDate.parse(date2, formato);
        Duration diff = Duration.between(start.atStartOfDay(), end.atStartOfDay());
        double diffDays = diff.toDays();

        try {
            PersonData report = new PersonData();
            double[] vacinForAgeRange = report.report(start,end);
            double[] averages = new double[4];

            for (int i=0;i<vacinForAgeRange.length;i++){
                averages[i] = vacinForAgeRange[i]/diffDays;
                System.out.println(averages[i]);
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
