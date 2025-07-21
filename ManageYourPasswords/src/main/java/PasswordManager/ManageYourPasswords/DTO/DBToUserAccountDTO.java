package PasswordManager.ManageYourPasswords.DTO;

 public class DBToUserAccountDTO {
    int id;
    String rootUserEmail;
    String websiteName;
    String userName;
    String email;
    String password;

    public DBToUserAccountDTO()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRootUserEmail() {
        return rootUserEmail;
    }

    public void setRootUserEmail(String rootUserEmail) {
        this.rootUserEmail = rootUserEmail;
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

    public DBToUserAccountDTO(int id, String rootUserEmail, String websiteName, String userName, String email, String password) {
        this.id = id;
        this.rootUserEmail = rootUserEmail;
        this.websiteName = websiteName;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}
