package hr.csa.backend.controllers;

import hr.csa.backend.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserAccountController {

    @Autowired
    private UserAccountService accountService;

    @Autowired
    private PasswordEncoder bcryptEncoder;
}
