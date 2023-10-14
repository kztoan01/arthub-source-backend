package com.example.ArtHub.MailConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String sender;

    @Override
    public String sendMail(MailDetail mailDetail) {

        try {


            SimpleMailMessage emailMessage = new SimpleMailMessage();


            emailMessage.setFrom(sender);
            emailMessage.setTo(mailDetail.getRecipient());
            emailMessage.setSubject(mailDetail.getSubject());
            emailMessage.setText(mailDetail.getMsgBody());


            mailSender.send(emailMessage);
            return "Email has been sent successfully...";
        }


        catch (Exception e) {
            return "Error while Sending email!!!";
        }
    }

    @Override
    public String sendMailWithAttachment(MailDetail mailDetail) {
        return null;
    }


}