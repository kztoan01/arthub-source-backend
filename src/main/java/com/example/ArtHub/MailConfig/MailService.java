package com.example.ArtHub.MailConfig;

public interface MailService {
    String sendMail(MailDetail mailDetail);

    String sendMailWithAttachment(MailDetail mailDetail);
}
