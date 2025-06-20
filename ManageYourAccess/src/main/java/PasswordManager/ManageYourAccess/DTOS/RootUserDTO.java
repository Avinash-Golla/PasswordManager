package PasswordManager.ManageYourAccess.DTOS;

public class RootUserDTO {

    private String email;
    private String userName;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public RootUserDTO(String email, String userName, String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
    }
}
