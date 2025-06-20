package PasswordManager.ManageYourAccess.Controllers;

import PasswordManager.ManageYourAccess.DTOS.ForgetPasswordDTO;
import PasswordManager.ManageYourAccess.DTOS.RootUserDTO;
import PasswordManager.ManageYourAccess.Services.RootUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RootUserController {

    @Autowired
    RootUserService rootUserService;

    @PostMapping("/register")
    public ResponseEntity<?> Register(@RequestBody RootUserDTO rootUserDTO)
    {
        return rootUserService.Register(rootUserDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateInfo(@RequestParam String email, @RequestBody RootUserDTO rootUserDTO)
    {
        return rootUserService.updateInfo(email, rootUserDTO);
    }

    @PutMapping("/updatePassword")
    public ResponseEntity<?> forgetPassword(@RequestBody ForgetPasswordDTO forgetPasswordDTO)
    {
         return rootUserService.forgetPassword(forgetPasswordDTO.getEmail(), forgetPasswordDTO.getPassword());
    }

}
