package PasswordManager.ManageYourPasswords.EntityPackage;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY )
    int id;
    String websiteName;
    String userName;
    String email;
    String password;
    @ManyToOne
    @JoinColumn(name="rootUser")
    @JsonBackReference
    RootUserEntity rootUser;

    public Account() {
    }


    public Account(int id, String websiteName, String userName, String email, String password) {
        this.id = id;
        this.websiteName = websiteName;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public RootUserEntity getRootUser() {
        return rootUser;
    }

    public void setRootUser(RootUserEntity rootUser) {
        this.rootUser = rootUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
