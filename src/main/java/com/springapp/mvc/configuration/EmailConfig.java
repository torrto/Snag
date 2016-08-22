package com.springapp.mvc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * Created by rhy704 on 8/22/16.
 */
@Configuration
@ComponentScan({ "com.springapp.mvc.configuration" })
public class EmailConfig {

    @Bean
    public MailSender mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setUsername("danielmltn@gmail.com");
        mailSender.setPassword("0walesCYMRU");
        mailSender.setPort(587);
        mailSender.setJavaMailProperties(properties());
        return mailSender;
    }

    private Properties properties(){
        Properties prop = new Properties();
        prop.put("mail.transport.protocol", "smtp");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.debug", "true");
//        prop.put("mail.smtp.ssl.enable", "true");

//        prop.put("mail.smtp.socketFactory.port", "465");
//        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        prop.put("mail.smtp.socketFactory.fallback", "false");
        return prop;
    }


}
