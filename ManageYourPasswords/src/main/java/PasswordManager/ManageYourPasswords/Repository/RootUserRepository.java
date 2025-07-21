package PasswordManager.ManageYourPasswords.Repository;

import PasswordManager.ManageYourPasswords.EntityPackage.RootUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.net.CacheRequest;

@Repository
public interface RootUserRepository extends JpaRepository<RootUserEntity, Integer> {

    RootUserEntity findByuserName(String userName);

    RootUserEntity findByEmail(String email);
}
