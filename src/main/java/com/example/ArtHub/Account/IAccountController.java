package com.example.ArtHub.Account;
import com.example.ArtHub.AppServiceExeption;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/accounts")
public interface IAccountController {
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    AccountResponeDTO createAccount(String username,String firstname,String lastname,MultipartFile image,String pass) throws AppServiceExeption, IOException;



    @GetMapping("/")
    List<AccountResponeDTO> getAccounts();
}
