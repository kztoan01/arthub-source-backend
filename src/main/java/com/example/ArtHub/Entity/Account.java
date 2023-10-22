package com.example.ArtHub.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,unique = true,name = "id")
    private int id;

    @Column(nullable = false,unique = true,name = "username")
    private String username;

    @Column(nullable = false,name = "password")
    private String password;

    @Column(nullable = false,name = "address")
    private String address;

    @Column(nullable = false,name = "lastname")
    private String lastname;

    @Column(nullable = false,name = "firstname")
    private String firstname;

    @Column(nullable = false,name = "phone")
    private String phone;

    @Column(nullable = false , length = 10000,name = "image")
    private String image;

    @Column(nullable = false,name = "email")
    private String email;

    @Column(nullable = false,name = "roleId")
    private String roleId;

    @Column(nullable = false,name = "twitter")
    private String twitter;

    @Column(nullable = false,name = "facebook")
    private String facebook;
    @Column(nullable = false,name = "bio")
    private  String bio;
    @Column(nullable = false,name = "isActive")
    private  String isActive;
    public Account() {
    }

    public Account(String username, String password, String address, String lastname, String firstname, String phone, String image, String email, String roleId, String twitter, String facebook, String bio, String isActive) {
        this.username = username;
        this.password = password;
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
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


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
}