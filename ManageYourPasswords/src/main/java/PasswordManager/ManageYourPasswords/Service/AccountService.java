package PasswordManager.ManageYourPasswords.Service;

import PasswordManager.ManageYourPasswords.DTO.AccountDTO;
import PasswordManager.ManageYourPasswords.DTO.DBToUserAccountDTO;
import PasswordManager.ManageYourPasswords.EntityPackage.Account;
import PasswordManager.ManageYourPasswords.EntityPackage.RootUserEntity;
import PasswordManager.ManageYourPasswords.Repository.AccountRepository;
import PasswordManager.ManageYourPasswords.Repository.RootUserRepository;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    RootUserRepository rootUserRepository;

    @Autowired
    AccountRepository accountRepository;

    public ResponseEntity<?> AddAccount(AccountDTO accountDTO) {
        System.out.println(accountDTO.getrootUserEmail());
        RootUserEntity rootUserEntity=rootUserRepository.findByEmail(accountDTO.getrootUserEmail());
        if(rootUserEntity==null)
            rootUserEntity=rootUserRepository.findByuserName(accountDTO.getrootUserEmail());
        if(rootUserEntity != null) {
            List<Account> rootUserEntityList = rootUserEntity.getListOfAccountsAlignedToRootUser();
            Account newAccount = new Account();
            newAccount.setEmail(accountDTO.getEmail());
            newAccount.setPassword(accountDTO.getPassword());
            newAccount.setWebsiteName(accountDTO.getWebsiteName());
            newAccount.setUserName(accountDTO.getUserName());
            newAccount.setRootUser(rootUserEntity);
            accountRepository.save(newAccount);
            return new ResponseEntity<>(Map.of("Message","Account Added Successfully"), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(Map.of("Message","No root User found with this details"), HttpStatus.NO_CONTENT);


    }

    public ResponseEntity<?> getAllAccounts(String emailOrUserName) {
        System.out.println("I am in get All Accounts of Account Service");

        RootUserEntity rootUserEntity =rootUserRepository.findByEmail(emailOrUserName);
        if(rootUserEntity == null) {
            rootUserEntity = rootUserRepository.findByuserName(emailOrUserName);
        }
        if (rootUserEntity != null) {
            List<Account> list = rootUserEntity.getListOfAccountsAlignedToRootUser();
            List<DBToUserAccountDTO> dtoList = list.stream().map(account -> {
                DBToUserAccountDTO dto = new DBToUserAccountDTO();
                dto.setId(account.getId());
                dto.setWebsiteName(account.getWebsiteName());
                dto.setUserName(account.getUserName());
                dto.setEmail(account.getEmail());
                dto.setPassword(account.getPassword());
                return dto;
            }).collect(Collectors.toList());

            return new ResponseEntity<>(dtoList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

    }



}
