package com.bus24.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService{
	@Autowired
private JavaMailSender javaMailSender;
	
	public String sendEmail(String to, String subject, String body) {
 String status="FAIL";
	SimpleMailMessage mail=new SimpleMailMessage();
      mail.setTo(to);
      mail.setSubject(subject);
      mail.setText(body);
      mail.setSentDate(new Date());
		javaMailSender.send(mail);
     status="SUCCESS";
		return status;
	}
}




