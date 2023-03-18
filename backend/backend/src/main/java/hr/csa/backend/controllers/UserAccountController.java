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
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
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
    public ResponseEntity<UserDTO> confirmLogin(@AuthenticationPrincipal User user, @RequestBody OneTimeCodeDTO oneTimeCodeDTO, @PathVariable Long idUserAccount){
        if(user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMINISTRATOR"))
                || user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"))){
            UserDTO userDTO = accountService.confirmLogin(oneTimeCodeDTO.getCode(), idUserAccount);
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    }

//    //stvara u bazi odma nekoliko usera
//    @EventListener
//	public void  appReady(ApplicationReadyEvent event) {
//        System.out.println("Pokrene se event listener");
//		accountService.createAdmins();
//	}
}
