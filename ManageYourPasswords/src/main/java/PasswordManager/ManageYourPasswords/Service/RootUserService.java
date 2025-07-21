package PasswordManager.ManageYourPasswords.Service;

import PasswordManager.ManageYourPasswords.DTO.AccountDTO;
import PasswordManager.ManageYourPasswords.DTO.DeleteRootUserEntity;
import PasswordManager.ManageYourPasswords.DTO.LoginDTO;
import PasswordManager.ManageYourPasswords.EntityPackage.Account;
import PasswordManager.ManageYourPasswords.EntityPackage.RootUserEntity;
import PasswordManager.ManageYourPasswords.Repository.RootUserRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RootUserService {

    @Autowired
    RootUserRepository rootUserRepository;

    @Autowired
    AccountService accountService;

    public ResponseEntity<?> GetRootUserEmail(String email)
    {
        RootUserEntity rootUserEntity=rootUserRepository.findByEmail(email);
        if(rootUserEntity != null)
        return new ResponseEntity<>(rootUserRepository.findByEmail(email), HttpStatus.OK);
        else
            return new ResponseEntity<>("No user found with the given Email", HttpStatus.NO_CONTENT);

    }
    public ResponseEntity<?> GetRootUserWithUserName(String userName)
    {
        RootUserEntity rootUserEntity=rootUserRepository.findByuserName(userName);
        if(rootUserEntity != null)
        return new ResponseEntity<>(rootUserRepository.findByuserName(userName), HttpStatus.OK);
        else
            return new ResponseEntity<>("No User found with this given UserName", HttpStatus.NO_CONTENT);
    }
    public ResponseEntity<?> RegisterRootUser(RootUserEntity rootUser)
    {
         RootUserEntity rootUserEntityEmail=rootUserRepository.findByEmail(rootUser.getEmail());
         RootUserEntity rootUserEntityUserName=rootUserRepository.findByuserName(rootUser.getUserName());
         if(rootUserEntityEmail !=null && rootUserEntityUserName !=null)
         {
             return new ResponseEntity<>("The user is already existing with this email and UserName", HttpStatus.OK);
         }
         else if(rootUserEntityEmail!=null)
             return new ResponseEntity<>("The user is already existing with this email", HttpStatus.OK);
         else if(rootUserEntityUserName!=null)
             return new ResponseEntity<>("The user is already existing with this userName", HttpStatus.OK);
         else{
             return new ResponseEntity<>(rootUserRepository.save(rootUser), HttpStatus.OK);
         }
    }

    public ResponseEntity<?> getAllRootUsers() {

        List<RootUserEntity> rootUserEntityList= rootUserRepository.findAll();

        if(rootUserEntityList.isEmpty())
        return new ResponseEntity<>("No users registered as Of Now, Be the first user", HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(rootUserEntityList, HttpStatus.OK);
    }

    public ResponseEntity<?> updateRootUser(RootUserEntity rootUserEntity) {

        RootUserEntity rootUserEntity1=rootUserRepository.findByEmail(rootUserEntity.getEmail());
        if(rootUserEntity1 ==null)
            return new ResponseEntity<>("The user does not exist with the given details,Please check the details ", HttpStatus.NO_CONTENT);
        else if(!rootUserEntity.getUserName()
                .equals(rootUserEntity1.getUserName()))
        {
            return new ResponseEntity<>("We have already a user with this, Please Provide another User Name", HttpStatus.NOT_ACCEPTABLE);
        }
        else
        {
            rootUserEntity1.setUserName(rootUserEntity.getUserName());
            rootUserEntity1.setPassword(rootUserEntity.getPassword());
            rootUserRepository.save(rootUserEntity1);
            return new ResponseEntity<>("Updated the Details, Login with new Credentials", HttpStatus.OK);
        }


    }

    public ResponseEntity<?> deleteRootUser(DeleteRootUserEntity deleteRootUserEntity) {
        RootUserEntity rootUserEntity= rootUserRepository.findByEmail(deleteRootUserEntity.getEmail());
        if(rootUserEntity != null) {
            rootUserRepository.delete(rootUserEntity);
            return new ResponseEntity<>("Deleted Root user with given gmail", HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("There is no root user with given credentials", HttpStatus.OK);


    }

    public ResponseEntity<?> LoginRootUser(LoginDTO loginDTO) {
        String emailOrUserName = loginDTO.getEmailOrUserName();

        RootUserEntity rootUserEntity = rootUserRepository.findByuserName(emailOrUserName);
        if (rootUserEntity == null) {
            rootUserEntity = rootUserRepository.findByEmail(emailOrUserName);
        }
        if(rootUserEntity !=null) {
            if (rootUserEntity.getPassword().equals(loginDTO.getPassword()))
            {
                return new ResponseEntity<>(Map.of("message","User allowed to Login"), HttpStatus.OK);
            }
            else
                return new ResponseEntity<>(Map.of("message","Invalid Credentials"), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(Map.of("message","User not found"), HttpStatus.NOT_FOUND);

}

    }


}

