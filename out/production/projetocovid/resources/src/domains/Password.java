package domains;

import data.PersonData;
import services.EmailService;

import java.io.IOException;
import java.sql.SQLException;

public class Password {
    public String createPassword() throws IOException {
        StringBuilder randomPassword = new StringBuilder();
        for (int j = 0; j <2; j++) {
            randomPassword.append(randomNumber());
            randomPassword.append(randomCharacter());

        }
        for (int j = 0; j < 2; j++) {
            randomPassword.append(randomCharacter());
            randomPassword.append(randomNumber());

        }
        System.out.println(randomPassword);

//        EmailService emailServices = new EmailService();

//        String subject = "Senha do seu cadastro no Vacin'aqui!!";
//        String content = "Olá novo funcionário essa é sua para acesso "+randomPassword+".\n" +
//                "Não esqueça que seu login é seu cpf, se esquecer é só clicar em redefinir sinha no login.";
//
//        emailServices.sendEmail(email, subject, content);
        return randomPassword.toString();
    }

    private static char randomCharacter() {

        int rand = (int) (Math.random() * 62);
        if (rand <= 35) {
            int uppercase = rand + 55;
            return (char) (uppercase);
        } else {
            int lowercase = rand + 61;
            return (char) (lowercase);
        }
    }

    private static char randomNumber() {
        int rand = (int) (Math.random() * 62);

        if (rand <= 9) {
            int number = rand + 48;
            return (char) (number);
        } else {
            return randomNumber();
        }
    }

//    public void forgetPassword(String email) throws IOException {
//        String newPassword = createPassword(email);
//        PersonData p = new PersonData();
//        try {
//            p.updatePassword(email,newPassword);
//        } catch (SQLException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//    }
}
