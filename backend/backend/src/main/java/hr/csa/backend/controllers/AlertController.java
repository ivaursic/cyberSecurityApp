package hr.csa.backend.controllers;

import hr.csa.backend.service.AlertService;
import hr.csa.backend.service.ThreatIntelligenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlertController {

    @Autowired
    private AlertService alertService;


}
