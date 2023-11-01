package com.example.ArtHub.Controller;


import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.Entity.Account;
import com.example.ArtHub.Repository.AccountRepository;
import com.example.ArtHub.ResponeObject.ResponeObject;
import com.example.ArtHub.Service.ServiceOfFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api")
public class AccountController {
    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ServiceOfFile serviceOfFile;
    //    @GetMapping("/accounts")
//    public ResponseEntity<List<Account>> getAllAccounts(@RequestParam(required = false) String name) {
//        try {
//            List<Account> accounts = new ArrayList<Account>();
//            if (name == null)
//                accountRepository.findAll().forEach(accounts::add);
//            else
//                accountRepository.findByNameContaining(name).forEach(accounts::add);
//
//            if (accounts.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//
//            return new ResponseEntity<>(accounts, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//
//        }
//    }
    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAllTutorials(@RequestParam(required = false) String name) {
        try {
            List<Account> accounts = new ArrayList<Account>();

            if (name == null)
                accountRepository.findAll().forEach(accounts::add);
            else
                accountRepository.findByUsernameContaining(name).forEach(accounts::add);

            if (accounts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(accounts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/accounts/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable("id") int id) {
        Optional<Account> accountData = accountRepository.findById(id);

        if (accountData.isPresent()) {
            return new ResponseEntity<>(accountData.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/accounts")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        try {
            List<Account> accounts = accountRepository.findByEmail(account.getEmail());
            if(!accounts.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }else{
                Account _account = accountRepository.save(new Account(
                        account.getUsername(),
                        account.getPassword(),
                        account.getAddress(),
                        account.getLastname(),
                        account.getFirstname(),
                        account.getPhone(),
                        account.getImage(),
                        account.getEmail(),
                        account.getRoleId(),
                        account.getTwitter(),
                        account.getFacebook(),
                        account.getBio(),
                        account.getIsActive()));
                return new ResponseEntity<>(_account,HttpStatus.CREATED);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/accounts")
    public ResponseEntity<Account> updateAccount( @RequestBody Account account ){
        Optional<Account> accountData = accountRepository.findById(account.getId());

        if(accountData.isPresent()){
            Account _account = accountData.get();
            _account.setUsername(account.getUsername());
            _account.setPassword(account.getPassword());
            _account.setAddress(account.getAddress());
            _account.setLastname(account.getLastname());
            _account.setFirstname(account.getFirstname());
            _account.setPhone(account.getPhone());
            _account.setImage(_account.getImage());
            _account.setEmail(account.getEmail());
            _account.setBio(account.getBio());
            _account.setRoleId(account.getRoleId());
            _account.setTwitter(account.getTwitter());
            _account.setFacebook(account.getFacebook());
            _account.setIsActive(account.getIsActive());
            return  new ResponseEntity<>(accountRepository.save(_account),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<HttpStatus> deleteAccount(@PathVariable("id") int id){
        try{
            accountRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/accounts")
    public ResponseEntity<HttpStatus> deleteAllAccounts(){
        try{
            accountRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/accounts/role")
    public  ResponseEntity<List<Account>> findByRole(){
        try{
            List<Account> accounts = accountRepository.findByRoleId("1");
            if(accounts.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(accounts,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/updateAccountImage")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponeObject> updateMainImageOfCourse(@RequestParam int accountId, @RequestParam MultipartFile image) throws AppServiceExeption, IOException {
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
        serviceOfFile.uploadFile(image);

        int rs = accountRepository.updateMainImageAccount(accountId,image.getOriginalFilename());

        if(rs!=0)
        {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("ok","update account image successfully!","")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("ok","update account image failed!","")
        );
    }



}
