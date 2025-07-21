package PasswordManager.ManageYourPasswords.Controller;


import PasswordManager.ManageYourPasswords.DTO.DeleteRootUserEntity;
import PasswordManager.ManageYourPasswords.DTO.LoginDTO;
import PasswordManager.ManageYourPasswords.EntityPackage.RootUserEntity;
import PasswordManager.ManageYourPasswords.Service.RootUserService;
import org.apache.commons.logging.Log;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class RootController {

    @Autowired
    RootUserService rootUserService;



    @PostMapping("/Register")
    public ResponseEntity<?> RegisterRootUser(@RequestBody RootUserEntity rootUser)
    {
        return new ResponseEntity<>(rootUserService.RegisterRootUser(rootUser), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> LoginRootUser(@RequestBody LoginDTO loginDTO)
    {
        System.out.println(loginDTO.getEmailOrUserName()+"  "+loginDTO.getPassword());
        return rootUserService.LoginRootUser(loginDTO);
    }

    @GetMapping("/email")
    public ResponseEntity<?> GetRootUserWithEmail(@RequestParam String email)
    {
        System.out.println("The Get Methods");

        return new ResponseEntity<>(rootUserService.GetRootUserEmail(email), HttpStatus.OK);
    }

    @GetMapping("/userName")
    public ResponseEntity<?> GetRootUserWithUserName(@RequestParam String userName)
    {
        return new ResponseEntity<>(rootUserService.GetRootUserWithUserName(userName), HttpStatus.OK);
    }

    @GetMapping("/AllRootUsers")
    public ResponseEntity<?> getAllRootUsers()
    {
        return new ResponseEntity<>(rootUserService.getAllRootUsers(), HttpStatus.OK);
    }

    @PutMapping("/updateRootUser")
    public ResponseEntity<?> updateRootUser(@RequestBody RootUserEntity rootUserEntity)
    {
        return rootUserService.updateRootUser(rootUserEntity);
    }
    @DeleteMapping("/DeleteRootUser")
    public ResponseEntity<?> deleteRootUser(@RequestBody DeleteRootUserEntity deleteRootUserEntity)
    {
        return rootUserService.deleteRootUser(deleteRootUserEntity);
    }

}
