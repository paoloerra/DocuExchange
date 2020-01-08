package controller;


import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {

    private static String USER_NAME = "docuexchangeSTAFF";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "prova123!"; // GMail password

    public static void SendRequestEmail(String toEmail, String name, String course, String professor, String description) {
    	String from = USER_NAME;
        String pass = PASSWORD;
        String[] to = { toEmail }; // list of recipient email addresses
        String subject = "Richiesta condivisione inviata";
        String body = "Ciao "+name+", la tua richiesta di condivisione inviata e in attesa per la verifica\n\nCorso:"+course+"\nProfessore:"+professor+"\nDescrizione:"+description+"";
        sendFromGMail(from, pass, to, subject, body);
    }
    
    public static void SendAcceptedEmail(String toEmail, String name) {
    	String from = USER_NAME;
        String pass = PASSWORD;
        String[] to = { toEmail }; // list of recipient email addresses
        String subject = "Richiesta condivisione accettata";
        String body = "Ciao "+name+", la tua richiesta di condivisione è stata accettata, potrai scaricare altri 3 appunti.";
        sendFromGMail(from, pass, to, subject, body);
    }
    
    public static void SendRifiutedEmail(String toEmail, String name) {
    	String from = USER_NAME;
        String pass = PASSWORD;
        String[] to = { toEmail }; // list of recipient email addresses
        String subject = "Richiesta condivisione rifiutata";
        String body = "Ciao "+name+", la tua richiesta di condivisione è stata rifiutata";
        sendFromGMail(from, pass, to, subject, body);
    }

    private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
}