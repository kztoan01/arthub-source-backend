package com.example.ArtHub.Account;
import com.example.ArtHub.AppServiceExeption;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/accounts")
public interface IAccountController {
    @PostMapping("/add")
    AccountResponeDTO createAccount(@RequestBody @Valid CreateAccountDTO dto) throws AppServiceExeption;

    @GetMapping("/")
    List<AccountResponeDTO> getAccounts();
}
