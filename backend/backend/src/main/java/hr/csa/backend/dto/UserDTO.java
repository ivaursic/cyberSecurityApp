package hr.csa.backend.dto;

import hr.csa.backend.domain.UserAccount;

public class UserDTO {

    private Long idUserAccount;

    private String mail;

    private String password;

    private String firstName;

    private String lastName;

    public UserDTO(Long idUserAccount, String mail, String password, String firstName, String lastName) {
        this.idUserAccount = idUserAccount;
        this.mail = mail;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public static UserDTO toDTO(UserAccount account) {
        return new UserDTO(account.getIdUserAccount(), account.getMail(), account.getPassword(), account.getFirstName(), account.getLastName());
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getIdUserAccount() {
        return idUserAccount;
    }
}
