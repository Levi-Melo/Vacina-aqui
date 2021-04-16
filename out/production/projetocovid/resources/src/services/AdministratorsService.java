package services;
import javax.swing.*;
import data.PersonData;
import entities.Person;



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
        String start = null;
        String end = null;
        PersonData report = new PersonData();
        report.report(start,end);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}