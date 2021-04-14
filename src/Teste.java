//import java.util.Properties;
//import javax.mail.Address;
//import javax.mail.Message;
//import javax.mail.internet.MimeMessage;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.swing.*;
//
//public class Teste
//{
//    public void sendPassword() {
//        Properties props = new Properties();
//
//        /** Parâmetros de conexão com servidor Gmail */
//        String remetente = "vacinaquiprojeto@gmail.com";
//        String password = "9c1pcot9";
//
//        props.put("mail.transport.protocol", "smtp"); //define protocolo de envio como SMTP
//        props.put("mail.smtp.starttls.enable","true");
//        props.put("mail.smtp.host", "smtp.gmail.com"); //server SMTP do GMAIL
//        props.put("mail.smtp.auth", "true"); //ativa autenticacao
//        props.put("mail.smtp.user", remetente); //usuario ou seja, a conta que esta enviando o email (tem que ser do GMAIL)
//        props.put("mail.debug", "true");
//        props.put("mail.smtp.port", "465"); //porta
//        props.put("mail.smtp.socketFactory.port", "465"); //mesma porta para o socket
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.socketFactory.fallback", "false");
//
//        Session session = Session.getDefaultInstance(props,
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication()
//                    {
//                        return new PasswordAuthentication(remetente,
//                                password);
//                    }
//                });
//
//        /** Ativa Debug para sessão */
//        session.setDebug(true);
//
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(remetente));
//            //Remetente
//
//            Address[] toUser = InternetAddress //Destinatário(s)
//                    .parse("levi.melo@outlook.com.br");
//
//            message.setRecipients(Message.RecipientType.TO, toUser);
//            message.setSubject("Enviando email com JavaMail");//Assunto
//            message.setText("Enviei este email utilizando JavaMail com minha conta GMail!");
//            /**Método para enviar a mensagem criada*/
//            Transport.send(message);
//
//            System.out.println("Feito!!!");
//
//        } catch (MessagingException  e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
//    }
//}