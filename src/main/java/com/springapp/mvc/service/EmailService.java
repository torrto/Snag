package com.springapp.mvc.service;

import com.springapp.mvc.model.ContentWrapper;
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

    public void sendEmail(ContentWrapper wrapper) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("danielmltn@gmail.com");
        message.setTo("danielmltn@gmail.com");
        message.setSubject("New Potential Applicant");
        message.setText(wrapper.getUser().getUsername() + " has passed the minimum qualifications. You can reach the applicant via email: "
        + wrapper.getUser().getEmail() + " or via phone: " + wrapper.getUser().getPhone());
        mailSender.send(message);

    }


}
