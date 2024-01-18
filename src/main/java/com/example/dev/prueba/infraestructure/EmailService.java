package com.example.dev.prueba.infraestructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String to, String subject, String content) {
        SimpleMailMessage messaje = new SimpleMailMessage();
        messaje.setTo(to);
        messaje.setSubject(subject);


        messaje.setText(content);

        // send email
        javaMailSender.send(messaje);
    }
}
