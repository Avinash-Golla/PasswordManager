package PasswordManager.ManageYourPasswords.Controller;


import PasswordManager.ManageYourPasswords.DTO.AccountDTO;
import PasswordManager.ManageYourPasswords.EntityPackage.Account;
import PasswordManager.ManageYourPasswords.EntityPackage.RootUserEntity;
import PasswordManager.ManageYourPasswords.Service.AccountService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/addAccount")
    public ResponseEntity<?> AddAccount(@RequestBody AccountDTO accountDTO)
    {
        System.out.println(accountDTO.getrootUserEmail()+" "+ accountDTO.getEmail()+" "+ accountDTO.getWebsiteName());
       System.out.println(accountDTO.getrootUserEmail());
        return accountService.AddAccount(accountDTO);

    }

    @GetMapping("/accounts")
    public ResponseEntity<?> getAccounts(@RequestParam String email) {
        System.out.println("I am in GetAccounts of controller");
      return accountService.getAllAccounts(email);
    }





}
