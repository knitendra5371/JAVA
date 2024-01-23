package com.send.email;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "preparing to send mail.....!!" );
        
        String message="Do you love me??";
        String subject="About Love";
        String to="khemkamehak1998@gmail.com";
        String from ="knitendra5371@gmail.com";
        
       // sendEmail(message,subject,to,from);   // this method only for sent simple text
        
        // send attach something...
        
        sendAttach(message,subject,to,from);
    }
    
    public static void sendAttach(String message,String subject,String to,String from) {
    	// variable for gmail
    	String host="smtp.gmail.com";
    	
    	// get the system properties
    	Properties properties=new Properties();
    	System.out.println("PROPERTIES"+ properties);
    	
    	// setting important information to properties object
    	// host set
    	properties.put("mail.smtp.host", host);
    	properties.put("mail.smtp.port", "465");
    	properties.put("mail.smtp.ssl.enable","true" );
    	properties.put("mail.smtp.auth", "true");
    	
    	// step 1: to get the session object..
    	
    	Session session=Session.getInstance(properties, new Authenticator() {

			/* (non-Javadoc)
			 * @see javax.mail.Authenticator#getPasswordAuthentication()
			 */
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("knitendra5371@gmail.com","sidd5371@786");
			}
    		
		});
    	
    	session.setDebug(true);
    	
    	MimeMessage m=new MimeMessage(session);
    	try {
    		m.setFrom(from);
    		
    		// adding recipient to message
    		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
    		
    		// adding subject to message
    		m.setSubject(subject);
    		
    		// attach something..
    		
    		MimeMultipart mimeMultipart =new MimeMultipart();
    		MimeBodyPart textPart=new MimeBodyPart();
    		MimeBodyPart filePart=new MimeBodyPart();
    		try {
				
				textPart.setText(message);
				
				File file=new File("/Users/apple/Downloads/I_love_you.jpg");
				
				filePart.attachFile(file);
				
				mimeMultipart.addBodyPart(textPart);
				mimeMultipart.addBodyPart(filePart);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    		m.setContent(mimeMultipart);
    		// send
    		
    		// step 3: send the message using transport class
    		Transport.send(m);
    		
    		System.out.println("sending success......!!");
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    }
    public static void sendEmail(String message,String subject,String to,String from) {
    	
    	// variable for gmail
    	String host="smtp.gmail.com";
    	
    	// get the system properties
    	Properties properties=new Properties();
    	System.out.println("PROPERTIES"+ properties);
    	
    	// setting important information to properties object
    	// host set
    	properties.put("mail.smtp.host", host);
    	properties.put("mail.smtp.port", "465");
    	properties.put("mail.smtp.ssl.enable","true" );
    	properties.put("mail.smtp.auth", "true");
    	
    	// step 1: to get the session object..
    	
    	Session session=Session.getInstance(properties, new Authenticator() {

			/* (non-Javadoc)
			 * @see javax.mail.Authenticator#getPasswordAuthentication()
			 */
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("knitendra5371@gmail.com","sidd5371@786");
			}
    		
		});
    	
    	session.setDebug(true);
    	
    	MimeMessage m=new MimeMessage(session);
    	try {
    		m.setFrom(from);
    		
    		// adding recipient to message
    		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
    		
    		// adding subject to message
    		m.setSubject(subject);
    		
    		// adding text to message
    		m.setText(message);
    		
    		// send
    		
    		// step 3: send the message using transport class
    		Transport.send(m);
    		
    		System.out.println("sending success......!!");
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	
    }
}
