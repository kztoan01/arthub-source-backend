package com.example.ArtHub.Service;

import com.example.ArtHub.AccountNotFoundException;
import com.example.ArtHub.DTO.CreateAccountDTO;
import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.Entity.Account;
import com.example.ArtHub.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceOfAccount implements IAccountService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account createAccount(CreateAccountDTO dto) throws AppServiceExeption {
        if(accountRepository.existsByUsername(dto.getUsername()))
        {
            throw new AppServiceExeption("User already existed!");
        }
        Account account = new Account();
        account.setUsername(dto.getUsername());
        account.setImage(dto.getImage());
        account.setPassword(dto.getPassword());
        account.setFirstname(dto.getFirstname());
        account.setLastname(dto.getLastname());
        account.setAddress(dto.getAddress());
        account.setFacebook(dto.getFacebook());
        return  accountRepository.save(account);
    }

    @Override
    public List<Account> getAccounts() {

        List<Account> accountListFrommDatabase = accountRepository.findAll();
        return accountListFrommDatabase;

    }

    @Override
    public Optional<Account> getAccountByCourseID(int id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account getAccountByID(int id) {
        return accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException(id));
    }


}