package com.example.ArtHub.Account;

import com.example.ArtHub.AppServiceExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService  implements InterfaceOfAccountService{
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
        account.setPassword(dto.getPassword());
        account.setFirstName(dto.getFirst_name());
        account.setLastName(dto.getLast_name());
        account.setAddress(dto.getAddress());
        account.setFacebook(dto.getFacebook());
        return  accountRepository.save(account);
    }

    @Override
    public List<Account> getAccounts() {

        List<Account> accountListFrommDatabase = accountRepository.findAll();
        return accountListFrommDatabase;

    }

}