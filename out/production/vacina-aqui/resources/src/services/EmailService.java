package services;
import static infrastructure.GetProperties.getPropertie;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.io.IOException;
import java.util.Properties;

public class EmailService {
    public void sendEmail( String receiver, String subject, String content ) throws IOException {
        Properties props = new Properties();

        String sender = getPropertie("email.user");
        String senderPassword = getPropertie("email.password");

        props.put("mail.transport.protocol", "smtp"); //define protocolo de envio como SMTP
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.host", "smtp.gmail.com"); //server SMTP do GMAIL
        props.put("mail.smtp.auth", "true"); //ativa autenticacao
        props.put("mail.smtp.user", sender); //usuario ou seja, a conta que esta enviando o email (tem que ser do GMAIL)
        props.put("mail.debug", "true");
        props.put("mail.smtp.port", "465"); //porta
        props.put("mail.smtp.socketFactory.port", "465"); //mesma porta para o socket
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        Session session = Session.getDefaultInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication()
                    {
                        return new PasswordAuthentication(sender,
                                senderPassword);
                    }
                });


        session.setDebug(true);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            //Remetente

            Address[] toUser = InternetAddress //Destinatário(s)
                    .parse(receiver);

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(subject);//subject
            message.setText(content);
            Transport.send(message);

            System.out.println("Feito!!!");

        } catch (MessagingException  e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

}