package PasswordManager.ManageYourPasswords.Repository;

import PasswordManager.ManageYourPasswords.EntityPackage.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer >{
}
