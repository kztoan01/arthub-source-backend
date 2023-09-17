package com.example.ArtHub.Account;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// Validation

public class CreateAccountDTO {
    @NotNull(message = "username cannot be null")
    @NotBlank(message = "username cannot be empty")
    private String username;

    @NotNull(message = "password cannot be null")
    @NotBlank(message = "password cannot be empty")
    private String password;

    private String last_name;

    private String first_name;

    private String image;

    private String address;

    private String phone;

    private String email;

    private Integer role;

    private String twitter;

    private String facebook;


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
}