package hr.csa.backend.dto;

import hr.csa.backend.domain.UserAccount;

public class LoginDTO {

    private String mail;

    private String password;

    public LoginDTO(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public static LoginDTO toDTO(UserAccount account) {
        return new LoginDTO(account.getMail(), account.getPassword());
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }
}
