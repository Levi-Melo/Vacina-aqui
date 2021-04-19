import data.ConnectionFactory;
import services.AttendantsService;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Teste {
    public static void main(String[] args) {

        String date1 = "12/04/2000";
        String date2 = "12/04/2001";

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate d1 = LocalDate.parse(date1, formato);
        LocalDate d2 = LocalDate.parse(date2, formato);

        Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
        double diffDays = diff.toDays();
        double fds = 200;
        double a = fds/diffDays;
        System.out.println(a);

    }
}