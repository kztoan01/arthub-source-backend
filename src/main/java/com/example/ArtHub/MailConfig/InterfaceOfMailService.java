package com.example.ArtHub.MailConfig;

public interface InterfaceOfMailService {
    String sendMail(MailDetail mailDetail);

    String sendMailWithAttachment(MailDetail mailDetail);
}
