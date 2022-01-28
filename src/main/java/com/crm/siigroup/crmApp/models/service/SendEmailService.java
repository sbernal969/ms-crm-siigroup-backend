package com.crm.siigroup.crmApp.models.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Data
@Service
public class SendEmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail (String to, String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("scarleth.bernal@siigoup.cl");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        mailSender.send(message);
    }
}
