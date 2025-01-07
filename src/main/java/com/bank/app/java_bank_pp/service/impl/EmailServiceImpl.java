package com.bank.app.java_bank_pp.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.bank.app.java_bank_pp.dto.EmailDetails;


public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    public EmailServiceImpl(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    @Value("${spring.mail.username}")
    private String sender;


    @Override
    public String sendEmail(EmailDetails emailDetails) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(emailDetails.getRecipient());
            mailMessage.setText(emailDetails.getMsgBody());
            mailMessage.setSubject(emailDetails.getSubject());

            javaMailSender.send(mailMessage);
            System.out.println("Mail sent successfully");
            return "Mail sent successfully";
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
