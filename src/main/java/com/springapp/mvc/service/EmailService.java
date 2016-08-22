package com.springapp.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

/**
 * Created by rhy704 on 8/22/16.
 */
@Component
public class EmailService {

    @Autowired
    MailSender mailSender;

    public void sendEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("danielmltn@gmail.com");
        message.setTo("danielmltn@gmail.com");
        message.setSubject("yo");
        message.setText("yo yo");
        mailSender.send(message);

    }


}
