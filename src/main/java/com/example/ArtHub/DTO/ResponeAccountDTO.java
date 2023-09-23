package com.example.ArtHub.DTO;

import com.example.ArtHub.Entity.Account;

import java.util.ArrayList;
import java.util.List;

public class ResponeAccountDTO {
    public static ResponeAccountDTO fromAccount(Account account) {
        ResponeAccountDTO accountResponseDTO = new ResponeAccountDTO();
        accountResponseDTO.setAccountId(account.getId());
        accountResponseDTO.setImage(account.getImage());
        accountResponseDTO.setUsername(account.getUsername());
        accountResponseDTO.setAddress(account.getAddress());
        accountResponseDTO.setLast_name(account.getLastname());
        accountResponseDTO.setFirst_name(account.getFirstname());
        accountResponseDTO.setEmail(account.getEmail());
        accountResponseDTO.setRole_id(account.getRoleId());
        accountResponseDTO.setTwitter(account.getTwitter());
        accountResponseDTO.setFacebook(account.getFacebook());
        accountResponseDTO.setPassword(account.getPassword());
        return accountResponseDTO;
    }

    public static List<ResponeAccountDTO> fromAccountList(List<Account> accountList) {
        List<ResponeAccountDTO> accountResponseDTOList = new ArrayList<>();
        for (Account account : accountList) {
            accountResponseDTOList.add(fromAccount(account));
        }
        return accountResponseDTOList;
    }

    private int accountId;
    private String username;

    private String password;

    private String address;

    private String last_name;

    private String first_name;

    private String phone;

    private String email;

    private String image;


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private String role_id;

    private  String twitter;

    private String facebook;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
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