package services;
import javax.swing.*;
import data.PersonData;
import entities.Person;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AdministratorsService{

    public void reportGenerator(String date1, String date2){

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
            }
            JOptionPane.showMessageDialog(null,
                    "Media para mais velhos que 90: "+averages[0]+"\n"+
                    "Media para os que estão entre 70 e 90: "+averages[1]+"\n"+
                    "Media para os que estão entre 50 e 70: "+averages[2]+"\n"+
                    "Media para mais novos que 50: "+averages[3]+"\n");
            return;
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
