package com.sachin.mail.mailsender;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

@SpringBootApplication
@RestController
public class MailSenderApplication {

	@Value("${gmail.username}")
	private String username;

	@Value("${gmail.password}")
	private String password;

	public static void main(String[] args)  {

		SpringApplication.run(MailSenderApplication.class, args);
	}
	@RequestMapping(value="/send",method= RequestMethod.POST)
	public String sendEmail(@RequestBody com.sachin.service.EmailMessage emailMessage) throws IOException,AddressException,MessagingException{
		sendmail(emailMessage);
		return "email sent";

	}

	private void sendmail(com.sachin.service.EmailMessage emailMessage) throws AddressException, MessagingException {

		Properties prop = new Properties();
		prop.put("mail.smtp.auth","true");
		prop.put("mail.smtp.starttls.enable","true");
		prop.put("mail.smtp.host","smtp.gmail.com");
		prop.put("mail.smtp.port","587");

		Session session = Session.getInstance(prop,
				new javax.mail.Authenticator(){
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username,password);
					}
				}
				);

		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(username,false));
		((MimeMessage) msg).setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailMessage.getTo_address()));
		msg.setSubject(emailMessage.getSubject());
		msg.setContent(emailMessage.getBody(),"text/html");
		Transport.send(msg);

	}


}
