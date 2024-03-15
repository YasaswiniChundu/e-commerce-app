package org.jsp.mailsenderapi.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class mailsendercontroller {
	@Autowired
	private JavaMailSender javaMailSender;
	private String token;
//	
//	@PostMapping("/send-mail")
//	public String sendMail(@RequestParam String email_id) {
//		
//		try {
//			MimeMessage message=javaMailSender.createMimeMessage();
//			MimeMessageHelper helper=new MimeMessageHelper(message);
//			helper.setSubject("Testing Mail Sending API");
//		    helper.setText("Creating this API to test our mail sending");
//		    helper.setTo(email_id);
//		    javaMailSender.send(message);
//		    return "Mail has been sent";
//		}catch(MessagingException e) {
//			e.printStackTrace();
//			return "Cannot send email";
//		}
	
	@PostMapping("/send-mail")
	public String sendMail(HttpServletRequest request,@RequestParam String email) {
		token="abcdefgh";
		String siteUrl=request.getRequestURL().toString();
		String url=siteUrl.replace(request.getServletPath(),"/verify")+"?token="+token;
		MimeMessage message=javaMailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);
		try {
			helper.setTo(email);
			helper.setSubject("Account Verification");
			helper.setText(url);
			javaMailSender.send(message);
			return "mail has been sent";
		}catch(MessagingException e) {
			e.printStackTrace();
			return "cannot send mail";
					
		}
	}
	
	@GetMapping("/verify")
	public String verify(@RequestParam String token) {
		if(this.token.equals(token))
			return "Verification Successfull";
		else
			return "Cannot Verify";
	}
 
}
