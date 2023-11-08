package com.example.ArtHub.DTO;

import jakarta.persistence.Column;

public class PayoutDTO {
    private int accountId;
    private Float TotalPayout;
    private String platform;
    private String recipientName;
    private String recipientUsername;
    private String recipientEmail;
    private String recipientPhone;


    public PayoutDTO(int accountId, Float totalPayout, String platform, String recipientName, String recipientUsername, String recipientEmail, String recipientPhone) {
        this.accountId = accountId;
        TotalPayout = totalPayout;
        this.platform = platform;
        this.recipientName = recipientName;
        this.recipientUsername = recipientUsername;
        this.recipientEmail = recipientEmail;
        this.recipientPhone = recipientPhone;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Float getTotalPayout() {
        return TotalPayout;
    }

    public void setTotalPayout(Float totalPayout) {
        TotalPayout = totalPayout;
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
}
