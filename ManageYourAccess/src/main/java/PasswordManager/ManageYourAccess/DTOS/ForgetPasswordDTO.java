package PasswordManager.ManageYourAccess.DTOS;

public class ForgetPasswordDTO {
    String email;
    String password;

    ForgetPasswordDTO (String email,String password)
    {
        this.email=email;
        this.password=password;
    }
    ForgetPasswordDTO()
    {

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
