package com.example.projetvolmanagement;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EnvoyerEmail {

    private String username = "azizhassine673@gmail.com";
    private String password = "efflqzxionrzzpow";

    public void envoyer() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("azizhassine673@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("achrafhafsia36@gmail.com"));
            message.setSubject("Hello from JavaFX mailing");
            message.setText("Bonjour from JavaFX system mailing");
            Transport.send(message);
            System.out.println("Message envoyé avec succès");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        EnvoyerEmail test = new EnvoyerEmail();
        test.envoyer();
    }
}
