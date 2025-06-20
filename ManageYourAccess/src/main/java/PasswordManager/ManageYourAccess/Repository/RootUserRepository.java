package PasswordManager.ManageYourAccess.Repository;

import PasswordManager.ManageYourAccess.Entity.RootUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RootUserRepository extends JpaRepository<RootUser,Long> {



    Optional<RootUser> findByEmail(String email);
}

