package PasswordManager.ManageYourPasswords.DTO;

public class LoginDTO {

    String emailOrUserName;
    String password;
    public LoginDTO(){

    }

    public LoginDTO(String emailOrUserName, String password) {

        this.emailOrUserName = emailOrUserName;
        this.password=password;
    }

    public String getEmailOrUserName() {
        return emailOrUserName;
    }

    public void setEmailOrUserName(String emailOrUserName) {
        this.emailOrUserName = emailOrUserName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
