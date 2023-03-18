package hr.csa.backend.controllers;

import hr.csa.backend.dto.LoginDTO;
import hr.csa.backend.dto.OneTimeCodeDTO;
import hr.csa.backend.dto.UserDTO;
import hr.csa.backend.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserAccountController {

    @Autowired
    private UserAccountService accountService;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @PostMapping("/registerUser")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO){
        UserDTO userDTORegistred = accountService.registerUser(userDTO);
        return new ResponseEntity<>(userDTORegistred, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> loginUser(@RequestBody LoginDTO loginDTO){
        UserDTO userDTO = accountService.loginUser(loginDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PostMapping("/confirmLogin/{idUserAccount}")
    public ResponseEntity<UserDTO> loginUser(@RequestBody OneTimeCodeDTO oneTimeCodeDTO, @PathVariable Long idUserAccount){
        UserDTO userDTO = accountService.confrimLogin(oneTimeCodeDTO, idUserAccount);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

//    //stvara u bazi odma nekoliko usera
    @EventListener
	public void  appReady(ApplicationReadyEvent event) {
        System.out.println("Pokrene se event listener");
		accountService.createAdmins();
	}
}
