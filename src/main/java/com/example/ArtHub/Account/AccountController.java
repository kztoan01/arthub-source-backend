package com.example.ArtHub.Account;

import com.example.ArtHub.AppServiceExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController implements IAccountController {
    @Autowired
    InterfaceOfAccountService accountsService;

    @Override
    public AccountResponeDTO createAccount(CreateAccountDTO dto) throws AppServiceExeption {
        Account account = accountsService.createAccount(dto);
        if (account == null) {
            return null;
        }
        return AccountResponeDTO.fromAccount(account);
    }

    @Override
    public List<AccountResponeDTO> getAccounts() {
        List<Account> accountList = accountsService.getAccounts();
        return AccountResponeDTO.fromAccountList(accountList);
    }
}