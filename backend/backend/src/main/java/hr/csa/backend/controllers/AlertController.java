package hr.csa.backend.controllers;

import hr.csa.backend.domain.ThreatLevel;
import hr.csa.backend.dto.AlertDTO;
import hr.csa.backend.dto.UserDTO;
import hr.csa.backend.service.AlertService;
import hr.csa.backend.service.ThreatIntelligenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class AlertController {

    @Autowired
    private AlertService alertService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAllAlerts")
    public ResponseEntity<List<AlertDTO>> getAllAlerts(@AuthenticationPrincipal User user){
        if(user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMINISTRATOR"))
                || user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"))){
            List<AlertDTO> list = alertService.getAll().stream().map(alert -> AlertDTO.toDTO(alert)).toList();
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAllHigh")
    public ResponseEntity<List<AlertDTO>> getAllHigh(@AuthenticationPrincipal User user){
        if(user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMINISTRATOR"))
                || user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"))){
            List<AlertDTO> list = alertService.getAll().stream().filter(alert -> alert.getThreatLevel() == ThreatLevel.HIGH).map(alert -> AlertDTO.toDTO(alert)).toList();
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAllMedium")
    public ResponseEntity<List<AlertDTO>> getAllMedium(@AuthenticationPrincipal User user){
        if(user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMINISTRATOR"))
                || user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"))){
            List<AlertDTO> list = alertService.getAll().stream().filter(alert -> alert.getThreatLevel() == ThreatLevel.MEDIUM).map(alert -> AlertDTO.toDTO(alert)).toList();
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAllLow")
    public ResponseEntity<List<AlertDTO>> getAllLow(@AuthenticationPrincipal User user){
        if(user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMINISTRATOR"))
                || user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"))){
            List<AlertDTO> list = alertService.getAll().stream().filter(alert -> alert.getThreatLevel() == ThreatLevel.LOW).map(alert -> AlertDTO.toDTO(alert)).toList();
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getNumberOfHigh")
    public ResponseEntity<Integer> getNumberOfHigh(@AuthenticationPrincipal User user){
        if(user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMINISTRATOR"))
                || user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"))){
            Integer count = alertService.getAll().stream().filter(alert -> alert.getThreatLevel() == ThreatLevel.HIGH).map(alert -> AlertDTO.toDTO(alert)).toList().size();
            return new ResponseEntity<>(count, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getNumberOfMedium")
    public ResponseEntity<Integer> getNumberOfMedium(@AuthenticationPrincipal User user){
        if(user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMINISTRATOR"))
                || user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"))){
            Integer count = alertService.getAll().stream().filter(alert -> alert.getThreatLevel() == ThreatLevel.MEDIUM).map(alert -> AlertDTO.toDTO(alert)).toList().size();
            return new ResponseEntity<>(count, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getNumberOfLow")
    public ResponseEntity<Integer> getNumberOfLow(@AuthenticationPrincipal User user){
        if(user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMINISTRATOR"))
                || user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"))){
            Integer count = alertService.getAll().stream().filter(alert -> alert.getThreatLevel() == ThreatLevel.LOW).map(alert -> AlertDTO.toDTO(alert)).toList().size();
            return new ResponseEntity<>(count, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    }



}
