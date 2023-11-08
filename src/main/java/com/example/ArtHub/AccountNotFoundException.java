package com.example.ArtHub;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(int id){
        super("Instructor with ID:"+id+"do not existed!!");
    }
}
