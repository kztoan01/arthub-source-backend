package com.example.ArtHub.Service;
import com.example.ArtHub.DTO.CreateAccountDTO;
import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.Entity.Account;

import  java.util.List;
public interface InterfaceOfAccountService {
    Account createAccount(CreateAccountDTO dto) throws AppServiceExeption;

    List<Account> getAccounts();
}