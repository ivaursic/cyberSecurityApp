package hr.csa.backend.controllers;


import hr.csa.backend.dto.AlertDTO;
import hr.csa.backend.dto.ThreatDTO;
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
public class ThreatIntelligenceController {

    @Autowired
    private ThreatIntelligenceService threatService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAllThreats")
    public ResponseEntity<List<ThreatDTO>> getAllAlerts(@AuthenticationPrincipal User user){
        if(user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMINISTRATOR"))
                || user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"))){
            return new ResponseEntity<>(threatService.getAll().stream().map(threat -> ThreatDTO.toDTO(threat)).toList(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    }




}
