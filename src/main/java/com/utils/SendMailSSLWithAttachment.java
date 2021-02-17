package com.utils;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;




public class SendMailSSLWithAttachment {
	
	
	public static void sendmail()
	{
	
		// Create object of Property file
				Properties props = new Properties();
		 
				// this will set host of server- you can change based on your requirement 
				props.put("mail.smtp.host","localhost" );
				
				
				//mail.protection.outlook.com
				//"smtp.office365.com"
		 
				// set the port of socket factory 
				//props.put("mail.smtp.socketFactory.port", "465");
				props.put("mail.smtp.ssl.trust", "*");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.EnableSSL.enable", "false");
				props.put("mail.debug", "true");
				
		 
				// set socket factory
				//props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		 
				// set the authentication to true
				props.put("mail.smtp.auth", "false");
		 
				// set the port of SMTP server
				props.put("mail.smtp.port", "440");
		 
				// This will handle the complete authentication
				Session session = Session.getDefaultInstance(props,
		 
						new javax.mail.Authenticator() {
		 
							protected PasswordAuthentication getPasswordAuthentication() {
		 
							return new PasswordAuthentication("damodr.bhatt@publicissapient.net", "Lion@1234");
		 
							}
		 
						});
		 
				try {
		 
					// Create object of MimeMessage class
					Message message = new MimeMessage(session);
		 
					// Set the from address
					message.setFrom(new InternetAddress("damodr.bhatt@publicissapient.net"));
		 
					// Set the recipient address
					message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("damomca@gmail.com"));
					message.setRecipients(Message.RecipientType.CC,InternetAddress.parse("damodar.pbmca@gmail.com"));
					//message.setRecipients(Message.RecipientType.CC,InternetAddress.parse("uma.yadav@publicissapient.com"));
					
					
					
					
		            
		                        // Add the subject link
					message.setSubject("Automation Report");
		 
					// Create object to add multimedia type content
					BodyPart messageBodyPart1 = new MimeBodyPart();
		 
					// Set the body of email
					messageBodyPart1.setText("HI All, \n\nPlease find the attached report");
		 
					// Create another object to add another content
					MimeBodyPart messageBodyPart2 = new MimeBodyPart();
		 
					// Mention the file which you want to send
					String filename = "/test-output/emailable-report.html";
		 
					// Create data source and pass the filename
					DataSource source = new FileDataSource(System.getProperty("user.dir")+filename);
		 
					// set the handler
					messageBodyPart2.setDataHandler(new DataHandler(source));
		 
					// set the file
					messageBodyPart2.setFileName(filename);
		 
					// Create object of MimeMultipart class
					Multipart multipart = new MimeMultipart();
		 
					// add body part 1
					multipart.addBodyPart(messageBodyPart2);
		 
					// add body part 2
					multipart.addBodyPart(messageBodyPart1);
		 
					// set the content
					message.setContent(multipart);
		 
					// finally send the email
					Transport.send(message);
		 
					System.out.println("=====Email Sent=====");
		 
				} catch (MessagingException e) {
		 e.printStackTrace();
					throw new RuntimeException(e);
		 
				}
				
				
				
		
		
		
	}

	public static void sendmailwithout()
	{
		
		 // change below lines accordingly 
        String to = "damomca@gmail.com"; 
        String from = "damodr.bhatt@publicissapient.net"; 
        String host = "smtp-mail.outlook.com"; // or IP address 
 
        // Get the session object 
        // Get system properties 
        Properties properties = System.getProperties(); 
 
        // Setup mail server 
        properties.setProperty("mail.smtp.host", "40.100.138.146"); 
 
        // Get the default Session object 
        Session session = Session.getDefaultInstance(properties); 
 
        // compose the message 
        try { 
 
            // javax.mail.internet.MimeMessage class 
            // is mostly used for abstraction. 
            MimeMessage message = new MimeMessage(session); 
 
            // header field of the header. 
            message.setFrom(new InternetAddress(from)); 
            message.addRecipient(Message.RecipientType.TO, 
                                new InternetAddress(to)); 
            message.setSubject("subject"); 
            message.setText("Hello, aas is sending email "); 
 
            // Send message 
            Transport.send(message); 
            System.out.println("Yo it has been sent.."); 
        } 
        catch (MessagingException mex) { 
            mex.printStackTrace(); 
        } 
		
	}
	
		
}


