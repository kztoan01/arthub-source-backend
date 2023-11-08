package com.example.ArtHub.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ResponseAccountDTO {

    private int id;

    private String username;

    private String address;

    private String lastname;

    private String firstname;

    private String phone;

    private String image;

    private String email;

    private String roleId;

    private String twitter;

    private String facebook;

    private  String bio;

    private  String isActive;
    private  String token;
    private  String isPremium;
    public ResponseAccountDTO() {
    }

    public ResponseAccountDTO(int id, String username, String address, String lastname, String firstname, String phone, String image, String email, String roleId, String twitter, String facebook, String bio, String isActive, String token, String isPremium) {
        this.id = id;
        this.username = username;
        this.address = address;
        this.lastname = lastname;
        this.firstname = firstname;
        this.phone = phone;
        this.image = image;
        this.email = email;
        this.roleId = roleId;
        this.twitter = twitter;
        this.facebook = facebook;
        this.bio = bio;
        this.isActive = isActive;
        this.token = token;
        this.isPremium = isPremium;
    }

    public String getIsPremium() {
        return isPremium;
    }

    public void setIsPremium(String isPremium) {
        this.isPremium = isPremium;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }
}
