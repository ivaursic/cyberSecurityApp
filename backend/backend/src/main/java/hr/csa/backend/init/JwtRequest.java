package hr.csa.backend.init;

import java.io.Serializable;

public class JwtRequest implements Serializable {

    private String mail;
    private String password;

    // need default constructor for JSON Parsing
    public JwtRequest() {

    }

    public JwtRequest(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public String getMail() {
        return this.mail;
    }

    public void setUsername(String username) {
        this.mail = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}