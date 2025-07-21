package PasswordManager.ManageYourPasswords.DTO;


public class AccountDTO {

    String id;
    String rootUserEmail;
    String websiteName;
    String userName;
    String email;
    String password;

    public AccountDTO() {
    }

    public AccountDTO(String rootUserEmail, String websiteName, String userName, String email, String password) {
        this.rootUserEmail = rootUserEmail;
        this.websiteName = websiteName;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public String getrootUserEmail() {
        return rootUserEmail;
    }

    public void setrootUserEmail(String gmail) {
        rootUserEmail = gmail;
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
