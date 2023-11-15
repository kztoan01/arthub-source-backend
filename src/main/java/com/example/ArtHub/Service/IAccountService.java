package com.example.ArtHub.Service;
import com.example.ArtHub.DTO.CreateAccountDTO;
import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.Entity.Account;
import org.springframework.data.jpa.repository.Query;

import  java.util.List;
import java.util.Optional;

public interface IAccountService {
    Account createAccount(CreateAccountDTO dto) throws AppServiceExeption;

    List<Account> getAccounts();

    Optional<Account> getAccountByCourseID(int id);


    @Query("Select a from Account a where a.id = ?1")
    Account getAccountByID(int id);
}