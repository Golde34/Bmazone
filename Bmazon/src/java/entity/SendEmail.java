/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author DELL
 */
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import static model.Editor.addTable;

public class SendEmail {

    //generate vrification code
    public String getRandom() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }
    
    

    //send email to the user email
    public boolean sendEmail(String username, String email, String code, String option) {
        boolean test = false;

        String toEmail = email;
        String fromEmail = "lilbmazonlab@gmail.com";
        String password = "Bmazon123";

        try {

            // host email smtp server details
            Properties pr = new Properties();
            // option1:
            pr.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
            pr.put("mail.smtp.port", "587"); //TLS Port
            pr.put("mail.smtp.auth", "true"); //enable authentication
            pr.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

            //option 2(failed):
//            pr.setProperty("mail.smtp.host", "smtp.mail.com");
//            pr.setProperty("mail.smtp.port", "587");
//            pr.setProperty("mail.smtp.auth", "true");
//            pr.setProperty("mail.smtp.starttls.enable", "true");
//            pr.put("mail.smtp.socketFactory.port", "587");
//            pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            //get session to authenticate the host email address and password
            Session session = Session.getInstance(pr, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });

            //set email message details
            Message msg = new MimeMessage(session);

            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");
            //set from email address
            msg.setFrom(new InternetAddress(fromEmail, "Bmazon"));
            msg.setReplyTo(InternetAddress.parse(fromEmail, false));
            //set to email address or destination email address
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            if (option.equals("register")) {
                //set email subject
                msg.setSubject("User Email Verification for Bmazon user");
                //set message text
                msg.setText("Hello, " + username + ". Please verify your account using this code: " + code);
            } else {
                msg.setSubject("The new password send to from Bmazon");
                msg.setContent(addTable(code), "text/html; charset=UTF-8");
            }

            //send the message
            Transport.send(msg);

            test = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return test;
    }
}
