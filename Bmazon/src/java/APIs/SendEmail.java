/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APIs;

/**
 *
 * @author DELL
 */
import java.security.SecureRandom;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import static APIs.Editor.addTable;
import static APIs.Editor.tableRegis;
import java.io.UnsupportedEncodingException;
import javax.mail.MessagingException;

public class SendEmail {

    //generate vrification code
    public String getRandom() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }

    public String randomString(int len) {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }

    //send email to the user email
    public static boolean sendEmail(String username, String email, String code, String option) {
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
                msg.setSubject("User Email Verification from Bmazon");
                //set message text
                msg.setContent(tableRegis(username, code), "text/html; charset=UTF-8");
            } else if (option.equals("editwallet")) {
                msg.setSubject("Wallet Request Verification from Bmazon");
                msg.setText("Please verify your request using this code: " + code);
            } else if (option.equals("forgot")){
                msg.setSubject("User Forgot Password on Bmazon ");
                msg.setContent(addTable(code), "text/html; charset=UTF-8");
            } else if (option.equals("topup")){
                msg.setSubject("Transaction's notification from Bmazon");
                msg.setText("Your transaction is successful. " + code);
            } else if (option.equals("denytopup")){
                msg.setSubject("Transaction's notification from Bmazon");
                msg.setText("Your transaction is failed. " + code);
            } else if (option.equals("order")){
                msg.setSubject("Order's notification from Bmazon");
                msg.setText(code);
            }

            //send the message
            Transport.send(msg);

            test = true;

        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
        }
        return test;
    }
}
