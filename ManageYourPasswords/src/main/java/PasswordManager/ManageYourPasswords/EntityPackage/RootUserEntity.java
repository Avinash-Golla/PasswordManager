package PasswordManager.ManageYourPasswords.EntityPackage;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class RootUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String userName;
    String password;
    String email;
    @OneToMany(mappedBy = "rootUser",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    List<Account> listOfAccountsAlignedToRootUser;

    public List<Account> getListOfAccountsAlignedToRootUser() {
        return listOfAccountsAlignedToRootUser;
    }

    public void setListOfAccountsAlignedToRootUser(List<Account> listOfAccountsAlignedToRootUser) {
        this.listOfAccountsAlignedToRootUser = listOfAccountsAlignedToRootUser;
    }

    RootUserEntity(int id, String userName, String password, String email)
    {
        this.id=id;
        this.userName=userName;
        this.password=password;
        this.email=email;

    }
    RootUserEntity(String userName, String password, String email)
    {

        this.userName=userName;
        this.password=password;
        this.email=email;

    }
    RootUserEntity()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
