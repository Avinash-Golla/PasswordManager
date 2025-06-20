package PasswordManager.ManageYourAccess.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class RootUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uniqueid;
    private String userName;
    private String password;
    private String email;

    public RootUser(Long uniqueid, String userName, String password, String email) {
        this.uniqueid = uniqueid;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }
    public RootUser(){

    }



    public Long getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(Long uniqueid) {
        this.uniqueid = uniqueid;
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
