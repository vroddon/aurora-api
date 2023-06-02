package project.aurora.api.utils;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.io.File;
import java.util.Properties;

public class SendEmail {
	
	public static void sendChangeEmail(String emailTO, String confirmationCode, CustomConfiguration customConfiguration) throws Exception {
		sendMail(emailTO, confirmationCode, 
				"AURORA APP - Change email confirmation code", 
				"To change your email, you must provide this confirmation code: ", customConfiguration);
	}
	
	public static void sendResetPassword(String emailTO, String confirmationCode, CustomConfiguration customConfiguration) throws Exception {
		sendMail(emailTO, confirmationCode, 
				"AURORA APP - Reset password confirmation code", 
				"To reset your password, you must provide this confirmation code: ", customConfiguration);
	}
	
	public static void sendZipFile(String emailTO, File zipFile, CustomConfiguration customConfiguration) throws Exception {
		sendMailWithFile(emailTO, zipFile, 
				"AURORA APP - Export user data", 
				"Attached zip file with the user data available in our system.", customConfiguration);
	}
	
	private static Properties readProperties(CustomConfiguration customConfiguration) {
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.host", customConfiguration.getMailSmtpHost());
		prop.put("mail.smtp.port", customConfiguration.getMailSmtpPort());
		return prop;
	}
	
	public static void sendMail(String emailTO, String confirmationCode, String subject, String messageText, CustomConfiguration customConfiguration) throws Exception {
		
		Properties prop = readProperties(customConfiguration);
		
        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(customConfiguration.getMailSmtpUser(), customConfiguration.getMailSmtpPass());
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(customConfiguration.getMailSmtpFrom()));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTO));
        message.setSubject(subject);

//        String msg = "This is my first email using JavaMailer";
//
//        MimeBodyPart mimeBodyPart = new MimeBodyPart();
//        mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

        String msgStyled = messageText + confirmationCode;
        MimeBodyPart mimeBodyPartWithStyledText = new MimeBodyPart();
        mimeBodyPartWithStyledText.setContent(msgStyled, "text/html; charset=utf-8");

//        MimeBodyPart attachmentBodyPart = new MimeBodyPart();

//        attachmentBodyPart.attachFile(getFile());

        Multipart multipart = new MimeMultipart();
//        multipart.addBodyPart(mimeBodyPart);
        multipart.addBodyPart(mimeBodyPartWithStyledText);
//        multipart.addBodyPart(attachmentBodyPart);

        message.setContent(multipart);

        Transport.send(message);
    }
	
	public static void sendMailWithFile(String emailTO, File zipFile, String subject, String messageText, CustomConfiguration customConfiguration) throws Exception {
		
		Properties prop = readProperties(customConfiguration);

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(customConfiguration.getMailSmtpUser(), customConfiguration.getMailSmtpPass());
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(customConfiguration.getMailSmtpFrom()));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTO));
        message.setSubject(subject);

        String msg = messageText;

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

//        String msgStyled = "This is my <b style='color:red;'>bold-red email</b> using JavaMailer";
//        MimeBodyPart mimeBodyPartWithStyledText = new MimeBodyPart();
//        mimeBodyPartWithStyledText.setContent(msgStyled, "text/html; charset=utf-8");

        MimeBodyPart attachmentBodyPart = new MimeBodyPart();

//        attachmentBodyPart.attachFile(getFile());
        attachmentBodyPart.attachFile(zipFile);

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);
//        multipart.addBodyPart(mimeBodyPartWithStyledText);
        multipart.addBodyPart(attachmentBodyPart);

        message.setContent(multipart);

        Transport.send(message);
    }


}
