package hr.csa.backend.controllers;

import hr.csa.backend.dto.LoginDTO;
import hr.csa.backend.dto.OneTimeCodeDTO;
import hr.csa.backend.dto.UserDTO;
import hr.csa.backend.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDTO>> getAllUsers(@AuthenticationPrincipal User user){
        if(user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMINISTRATOR"))){
            List<UserDTO> list = accountService.getAll().stream().filter(userAccount -> userAccount.isAdministrator() == false).map(account -> UserDTO.toDTO(account)).collect(Collectors.toList());
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    }

    @GetMapping("/getAllAdmins")
    public ResponseEntity<List<UserDTO>> getAllAdmins(@AuthenticationPrincipal User user){
        if(user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMINISTRATOR"))){
            List<UserDTO> list = accountService.getAll().stream().filter(userAccount -> userAccount.isAdministrator() == true).map(account -> UserDTO.toDTO(account)).collect(Collectors.toList());
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    }

    @PostMapping("/deleteUser")
    public ResponseEntity<Boolean> deleteUser(@AuthenticationPrincipal User user, @PathVariable Long idUserAccount){
        if(user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMINISTRATOR"))){
            accountService.deleteUser(idUserAccount);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);

    }


//    //stvara u bazi odma nekoliko usera
//    @EventListener
//	public void  appReady(ApplicationReadyEvent event) {
//        System.out.println("Pokrene se event listener");
//		accountService.createAdmins();
//	}
}
