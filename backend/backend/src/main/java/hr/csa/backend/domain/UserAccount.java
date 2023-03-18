package hr.csa.backend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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

    @NotNull(message = "last name shouldn't be null")
    private String lastName;


    public UserAccount(String mail, String password, String firstName, String lastName) {
        this.mail = mail;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
