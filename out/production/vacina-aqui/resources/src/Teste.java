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
        LocalDate date = LocalDate.now();
        String porra = String.valueOf(date);
        System.out.println(porra);

    }
}