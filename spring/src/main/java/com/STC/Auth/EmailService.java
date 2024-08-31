package com.STC.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }
    public String generateResetToken() {
        return UUID.randomUUID().toString();
    }
    public void sendPasswordResetEmail(String email, String token) {
        String url = "http://yourdomain.com/reset-password?token=" + token;
        String subject = "Password Reset Request";
        String message = "To reset your password, click the link below:\n" + url;

        sendSimpleEmail(email, subject, message);
    }

}
