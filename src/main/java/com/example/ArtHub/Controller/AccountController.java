package com.example.ArtHub.Controller;


import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.ResponseAccountDTO;
import com.example.ArtHub.Entity.Account;
import com.example.ArtHub.MailConfig.InterfaceOfMailService;
import com.example.ArtHub.MailConfig.MailDetail;
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
public class AccountController  {
    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ServiceOfFile serviceOfFile;
    @Autowired
    private InterfaceOfMailService mailService;

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
    public ResponseEntity<List<Account>> getAllAccounts(@RequestParam(required = false) String name) {
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

    @PostMapping("/accounts/GoogleLogin")
    public ResponseEntity<ResponseAccountDTO> LoginGoogleAccount(@RequestParam String email) {
        Optional<Account> userAccount = accountRepository.findByEmail(email);
        if (userAccount.isPresent()) {
            ResponseAccountDTO responseAccountDTO = new ResponseAccountDTO();
            responseAccountDTO.setId(userAccount.get().getId());
            responseAccountDTO.setUsername(userAccount.get().getUsername());
            responseAccountDTO.setAddress(userAccount.get().getAddress());
            responseAccountDTO.setLastname(userAccount.get().getLastname());
            responseAccountDTO.setFirstname(userAccount.get().getFirstname());
            responseAccountDTO.setPhone(userAccount.get().getPhone());
            responseAccountDTO.setImage(userAccount.get().getImage());
            responseAccountDTO.setEmail(userAccount.get().getEmail());
            responseAccountDTO.setRoleId(userAccount.get().getRoleId());
            responseAccountDTO.setTwitter(userAccount.get().getTwitter());
            responseAccountDTO.setFacebook(userAccount.get().getFacebook());
            responseAccountDTO.setBio(userAccount.get().getBio());
            responseAccountDTO.setIsActive(userAccount.get().getIsActive());
            responseAccountDTO.setIsPremium(userAccount.get().getIsPremium());
            return new ResponseEntity<>(responseAccountDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/accounts/changePassword")
    public ResponseEntity<ResponseAccountDTO> ChangePassword(@RequestParam String email, @RequestParam String newPassword, @RequestParam String oldPassword) {
        Optional<Account> userAccount = accountRepository.findByEmail(email);
        if (userAccount.isPresent()) {
            if (!userAccount.get().getPassword().equals(oldPassword)) {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            } else {
                int changed = accountRepository.updatePassword(email, newPassword);
                if (changed != 0) {
                    return new ResponseEntity<>(HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/accounts/login")
    public ResponseEntity<ResponseAccountDTO> LoginAccount(@RequestParam String email, @RequestParam String password) {
        Optional<Account> userAccount = accountRepository.findByEmail(email);
        if (userAccount.isPresent()) {
            if (userAccount.get().getPassword().equals(password)) {
                ResponseAccountDTO responseAccountDTO = new ResponseAccountDTO();
                responseAccountDTO.setId(userAccount.get().getId());
                responseAccountDTO.setUsername(userAccount.get().getUsername());
                responseAccountDTO.setAddress(userAccount.get().getAddress());
                responseAccountDTO.setLastname(userAccount.get().getLastname());
                responseAccountDTO.setFirstname(userAccount.get().getFirstname());
                responseAccountDTO.setPhone(userAccount.get().getPhone());
                responseAccountDTO.setImage(userAccount.get().getImage());
                responseAccountDTO.setEmail(userAccount.get().getEmail());
                responseAccountDTO.setRoleId(userAccount.get().getRoleId());
                responseAccountDTO.setTwitter(userAccount.get().getTwitter());
                responseAccountDTO.setFacebook(userAccount.get().getFacebook());
                responseAccountDTO.setBio(userAccount.get().getBio());
                responseAccountDTO.setIsActive(userAccount.get().getIsActive());
                responseAccountDTO.setToken(userAccount.get().getToken());
                responseAccountDTO.setIsPremium(userAccount.get().getIsPremium());
                return new ResponseEntity<>(responseAccountDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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

    @PostMapping("/accounts/checkToken")
    public ResponseEntity<Account> checkToken(@RequestParam int id, @RequestParam String token) {
        Optional<Account> userAccount = accountRepository.findById(id);
        if (userAccount.isPresent()) {
            if (userAccount.get().getToken().equals(token)) {
                int updateToken = accountRepository.updateToken(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public boolean sendMailToReceiver(String email, String token) throws AppServiceExeption, IOException {
        String messageBody = "";
        String subject = "";

        messageBody = "Hello,\n" +
                "Please use the verification code below on the ArtHub website\n\n" +
                token + "\n\n" +
                "If you didn't request this, you can ignore this email or let us know.\n" +
                "Thanks! ArtHub team";
        subject = "ArtHub OTP verification";

        MailDetail mailDetail = new MailDetail();
        mailDetail.setMsgBody(messageBody);
        mailDetail.setRecipient(email);
        mailDetail.setSubject(subject);
        mailService.sendMail(mailDetail);
        return true;
    }

    @PostMapping("/accounts")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        try {
            Optional<Account> accountbyEmail = accountRepository.findByEmail(account.getEmail());
            Optional<Account> accountbyUsername = accountRepository.findByUsername(account.getUsername());
            if (!accountbyEmail.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN); //email exist
            } else if (!accountbyUsername.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); //username exist
            } else {
                if(account.getToken() != null)//send otp
                {
                    boolean sendToken = sendMailToReceiver(account.getEmail(), account.getToken());
                }
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
                        account.getIsActive(),
                        account.getToken(),
                        account.getIsPremium()));
                return new ResponseEntity<>(_account, HttpStatus.CREATED);
            }

        } catch (Exception | AppServiceExeption e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/accounts")
    public ResponseEntity<Account> updateAccount(@RequestBody Account account) {
        Optional<Account> accountData = accountRepository.findById(account.getId());

        if (accountData.isPresent()) {
            Account _account = accountData.get();
            _account.setUsername(account.getUsername());
            if (account.getPassword() == null) {
                _account.setPassword(_account.getPassword());
            } else {
                _account.setPassword(account.getPassword());
            }
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
            _account.setIsPremium(account.getIsPremium());
            return new ResponseEntity<>(accountRepository.save(_account), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<HttpStatus> deleteAccount(@PathVariable("id") int id) {
        try {
            accountRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/accounts")
    public ResponseEntity<HttpStatus> deleteAllAccounts() {
        try {
            accountRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/accounts/role")
    public ResponseEntity<List<Account>> findByRole() {
        try {
            List<Account> accounts = accountRepository.findByRoleId("1");
            if (accounts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(accounts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/updateAccountImage")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponeObject> updateMainImageOfCourse(@RequestParam int accountId, @RequestParam MultipartFile image) throws AppServiceExeption, IOException {
        serviceOfFile.uploadFile(image);

        int rs = accountRepository.updateMainImageAccount(accountId, image.getOriginalFilename());

        if (rs != 0) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("ok", "update account image successfully!", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("ok", "update account image failed!", "")
        );
    }


}
