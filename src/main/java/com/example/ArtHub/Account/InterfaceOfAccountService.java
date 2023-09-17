package com.example.ArtHub.Account;
import com.example.ArtHub.AppServiceExeption;

import  java.util.List;
public interface InterfaceOfAccountService {
    Account createAccount(CreateAccountDTO dto) throws AppServiceExeption;

    List<Account> getAccounts();
}