package com.example.ArtHub.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Payout")
public class Payout {


    public Payout(int id, int accountId, String platform, String recipientName, String recipientUsername, String recipientEmail, String recipientPhone, String recipient) {
        this.id = id;
        this.accountId = accountId;
        this.platform = platform;
        this.recipientName = recipientName;
        this.recipientUsername = recipientUsername;
        this.recipientEmail = recipientEmail;
        this.recipientPhone = recipientPhone;
        this.recipient = recipient;
    }

    public Payout() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,unique = true,name = "id")
    private int id;

    @Column(nullable = false,name = "accountId")
    private int accountId;

    @Column(nullable = false,name = "platform")
    private String platform;

    @Column(nullable = false,name = "recipientName")
    private String recipientName;

    @Column(nullable = false,name = "recipientUsername")
    private String recipientUsername;

    @Column(nullable = false,name = "recipientEmail")
    private String recipientEmail;

    @Column(nullable = false,name = "recipientPhone")
    private String recipientPhone;

    @Column(nullable = false,name = "recipient")
    private String recipient;

    public Payout(int accountId, String platform, String recipientName, String recipientUsername, String recipientEmail, String recipientPhone, String recipient) {
        this.accountId = accountId;
        this.platform = platform;
        this.recipientName = recipientName;
        this.recipientUsername = recipientUsername;
        this.recipientEmail = recipientEmail;
        this.recipientPhone = recipientPhone;
        this.recipient = recipient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientUsername() {
        return recipientUsername;
    }

    public void setRecipientUsername(String recipientUsername) {
        this.recipientUsername = recipientUsername;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}