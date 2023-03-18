package hr.csa.backend.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

import java.io.Serializable;

@Entity
public class UserAccount implements Serializable {

    @Id
    @GeneratedValue
    private Long idUserAccount;

    @Column(unique = true)
    @NotNull(message = "username shouldn't be null")
    private String mail;

    @NotNull(message = "password shouldn't be null")
    @Size(min = 8)
    private String password;

    @NotNull(message = "first name shouldn't be null")
    private String firstName;

    @NotNull(message = "last name shouldn't be null")
    private String lastName;

    private String mfaOneTimePassword;

    private boolean isAdministrator;

    public String getMfaOneTimePassword() {
        return mfaOneTimePassword;
    }

    public void setMfaOneTimePassword(String mfaOneTimePassword) {
        this.mfaOneTimePassword = mfaOneTimePassword;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Long getIdUserAccount() {
        return idUserAccount;
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
    public UserAccount() {
    }

    public UserAccount(String mail, String password, String firstName, String lastName) {
        this.mail = mail;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public boolean isAdministrator() {
        return isAdministrator;
    }

}
