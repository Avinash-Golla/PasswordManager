package PasswordManager.ManageYourAccess.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {

    @Id
    private Long uniqueid;
    private String username;
    private String email;
    private String password;
    private String website;

    Account(Long uniqueid,String website, String username, String email, String password)
    {
        this.uniqueid=uniqueid;
        this.website=website;
        this.username=username;
        this.email=email;
        this.password=password;
    }

    public Long getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(Long uniqueid) {
        this.uniqueid = uniqueid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
