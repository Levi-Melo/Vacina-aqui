package entities;

import services.EmailService;

public class Password {
    public String createPassword(String email){
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

        EmailService emailServices = new EmailService();

        String subject = "Senha do seu cadastro no Vacin'aqui!!";
        String content = "Olá novo funcionário essa é sua para acesso "+randomPassword+".\n" +
                "Não esqueça que seu login é seu cpf, se esquecer é só clicar em redefinir sinha no login.";

        emailServices.sendEmail(email, subject, content);
        return randomPassword;
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


}
