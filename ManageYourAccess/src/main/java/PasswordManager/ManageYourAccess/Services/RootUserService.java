package PasswordManager.ManageYourAccess.Services;

import PasswordManager.ManageYourAccess.DTOS.RootUserDTO;
import PasswordManager.ManageYourAccess.Entity.RootUser;
import PasswordManager.ManageYourAccess.Repository.RootUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RootUserService {

    @Autowired
    RootUserRepository rootUserRepository;

    public ResponseEntity<?> Register(RootUserDTO rootUserDTO)
    {
        Optional<RootUser> rootUser=rootUserRepository.findByEmail(rootUserDTO.getEmail());
        if(rootUser.isPresent())
                return new ResponseEntity<>("User Already exist",HttpStatus.NOT_ACCEPTABLE);

            RootUser user = new RootUser();
            user.setUserName(rootUserDTO.getUserName());
            user.setEmail(rootUserDTO.getEmail());
            user.setPassword(rootUserDTO.getPassword());
            rootUserRepository.save(user);


        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }

    public ResponseEntity<?> updateInfo(String email, RootUserDTO rootUserDTO) {

        Optional<RootUser> optionalUser=rootUserRepository.findByEmail(email);
        if((optionalUser.isPresent())) {
            RootUser user = optionalUser.get();
            user.setUserName(rootUserDTO.getUserName());
            user.setEmail(rootUserDTO.getEmail());
            user.setPassword(rootUserDTO.getPassword());
            rootUserRepository.save(user);
            return new ResponseEntity<>(user,HttpStatus.OK);
        }
        return new ResponseEntity<>("There are no users with the given Email, Please Check your Email Address",HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity<?> forgetPassword(String email, String password) {
        Optional<RootUser> optionalUser=rootUserRepository.findByEmail(email);
        if((optionalUser.isPresent())) {
            RootUser user = optionalUser.get();
            user.setPassword(password);
            rootUserRepository.save(user);
            return new ResponseEntity<>("Password is updated , Please Login", HttpStatus.OK);
        }
        return new ResponseEntity<>("There is no user with provided Email, Please check the email", HttpStatus.NOT_ACCEPTABLE);

    }
}
