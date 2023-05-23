package com.example.projetvolmanagement;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EnvoyerEmail {

    private String username = "azizhassine673@gmail.com";
    private String password = "efflqzxionrzzpow";

    public void envoyer(String ch) {
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
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(ch));
            message.setSubject("Cher passager");
            message.setText("Après avoir traité votre demande, nous sommes heureux de vous informer que nous avons réservé un billet pour vous. Veuillez consulter notre plateforme pour télécharger votre ticket.");

// Ajouter un objet à l'e-mail
            message.setHeader("Content-Type", "text/plain; charset=UTF-8");
            message.setHeader("Content-Transfer-Encoding", "quoted-printable");
            message.setHeader("Content-Disposition", "inline");
            message.setHeader("Content-Language", "fr");
            Transport.send(message);
            System.out.println("Message envoyé avec succès");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
