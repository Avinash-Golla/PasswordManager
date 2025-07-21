package PasswordManager.ManageYourPasswords;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class HelloWorldController {

    @GetMapping()
    public ResponseEntity<?> hello()
    {
        return new ResponseEntity<>("Hello, World. Manage your Passwords with proper security", HttpStatus.OK);
    }


}
