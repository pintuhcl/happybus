package com.cba.processing;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class CBAEmailServiceImpl 
implements CBAEmailService{
	private static Logger logger=Logger.getLogger(CBAEmailService.class);
	@Autowired
	private JavaMailSender javaMailSender;
public String sendOperationsInfoEmail
(String to, String subject, String body) {
	String status="FAILURE";
	MimeMessage message=javaMailSender.createMimeMessage();
      MimeMessageHelper messageHelper=new 
    		  MimeMessageHelper(message);
      try {
		messageHelper.setTo(to);
		messageHelper.setText(body);
	      messageHelper.setSubject(subject);
	       javaMailSender.send(message);
		status="SUCCESS";
	} catch (MessagingException e) {
logger.error("Exception Occured while sending the email : "+e);	
	}catch (Exception e) {
logger.error("Exception Occured while sending the email : "+e);	
	}
      return status;
	}
}
