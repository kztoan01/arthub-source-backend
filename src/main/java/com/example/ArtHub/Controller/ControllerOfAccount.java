package com.example.ArtHub.Controller;

import com.cloudinary.Cloudinary;
import com.example.ArtHub.CloudinaryConfig;
import com.example.ArtHub.DTO.ResponeAccountDTO;
import com.example.ArtHub.DTO.CreateAccountDTO;
import com.example.ArtHub.InterfaceOfControllers.InterfaceOfAccountController;
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
import java.util.Map;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ControllerOfAccount implements InterfaceOfAccountController {
    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));
    @Autowired
    InterfaceOfAccountService accountsService;

    @Autowired
    CloudinaryConfig cloudinaryConfig;


    @Override
    public ResponeAccountDTO createAccount(@RequestParam String username,
                                           @RequestParam String firstname,
                                           @RequestParam String lastname,
                                           @RequestParam MultipartFile image,
                                           @RequestParam String password) throws AppServiceExeption, IOException {
//        Path staticPath = Paths.get("static");
//        Path imagePath = Paths.get("images");
//        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
//            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
//        }
//        Path file = CURRENT_FOLDER.resolve(staticPath)
//                .resolve(imagePath).resolve(image.getOriginalFilename());
//        try (OutputStream os = Files.newOutputStream(file)) {
//
//            os.write(image.getBytes());
//        }


        String savedImageName = cloudinaryConfig.cloudinary().uploader()
                .upload(image.getBytes(),
                        Map.of("public_id", UUID.randomUUID().toString()))
                .get("url")
                .toString();

        CreateAccountDTO account = new CreateAccountDTO();
        account.setUsername(username);
        account.setPassword(password);
        account.setFirstname(firstname);
        account.setLastname(lastname);
        account.setImage(savedImageName);
        Account accountEntity = accountsService.createAccount(account);
        return ResponeAccountDTO.fromAccount(accountEntity);
    }

    @Override
    public List<ResponeAccountDTO> getAccounts() {
        List<Account> accountList = accountsService.getAccounts();
        return ResponeAccountDTO.fromAccountList(accountList);
    }
}