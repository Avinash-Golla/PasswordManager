package PasswordManager.ManageYourAccess.Repository;

import PasswordManager.ManageYourAccess.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordRepo extends JpaRepository<Account, String> {
}
