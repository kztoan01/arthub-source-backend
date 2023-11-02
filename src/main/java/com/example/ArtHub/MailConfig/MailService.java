package com.example.ArtHub.MailConfig;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;


@Service
public class MailService implements InterfaceOfMailService {
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
    public String
    sendMailWithAttachment(MailDetail details)
    {
        MimeMessage mimeMessage
                = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {
            mimeMessageHelper
                    = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(details.getRecipient());
            mimeMessageHelper.setText(details.getMsgBody());
            mimeMessageHelper.setSubject(
                    details.getSubject());

            FileSystemResource file
                    = new FileSystemResource(
                    new File(details.getAttachment()));

            mimeMessageHelper.addAttachment(
                    file.getFilename(), file);

            mailSender.send(mimeMessage);
            return "Mail sent Successfully";
        }

        catch (MessagingException e) {

            return "Error while sending mail!!!";
        }
    }


}