package com.example.ArtHub.Controller;

import com.example.ArtHub.DTO.ResponeAccountDTO;
import com.example.ArtHub.DTO.CreateAccountDTO;
import com.example.ArtHub.Service.InterfaceOfAccountService;
import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.Entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class AccountController implements InterfaceOfAccountController {
    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));
    @Autowired
    InterfaceOfAccountService accountsService;


    @Override
    public ResponeAccountDTO createAccount(@RequestParam String username,
                                           @RequestParam String first_name,
                                           @RequestParam String last_name,
                                           @RequestParam MultipartFile image,
                                           @RequestParam String password) throws AppServiceExeption, IOException {
        Path staticPath = Paths.get("static");
        Path imagePath = Paths.get("images");
        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
        }
        Path file = CURRENT_FOLDER.resolve(staticPath)
                .resolve(imagePath).resolve(image.getOriginalFilename());
        try (OutputStream os = Files.newOutputStream(file)) {

            os.write(image.getBytes());
        }
        //http://localhost:8080\\images\\test.jpg
        CreateAccountDTO account = new CreateAccountDTO();
        account.setUsername(username);
        account.setPassword(password);
        account.setFirst_name(first_name);
        account.setLast_name(last_name);
        account.setImage(image.getOriginalFilename());
        Account accountEntity = accountsService.createAccount(account);
        return ResponeAccountDTO.fromAccount(accountEntity);
    }

    @Override
    public List<ResponeAccountDTO> getAccounts() {
        List<Account> accountList = accountsService.getAccounts();
        return ResponeAccountDTO.fromAccountList(accountList);
    }
}