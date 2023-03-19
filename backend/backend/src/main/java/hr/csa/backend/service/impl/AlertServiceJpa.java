package hr.csa.backend.service.impl;

import hr.csa.backend.dao.AlertRepository;
import hr.csa.backend.domain.Alert;
import hr.csa.backend.domain.ThreatIntelligence;
import hr.csa.backend.domain.UserAccount;
import hr.csa.backend.dto.AlertDTO;
import hr.csa.backend.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertServiceJpa implements AlertService {

    @Autowired
    private AlertRepository alertRepository;

    @Override
    public AlertDTO createNewAlert(ThreatIntelligence threat) {
        Alert alert = new Alert();
        alert.setThreatLevel(threat.getLevel());
        alert.setMessage("New threat arrived. File " + threat.getName()+ " uploaded.");
        alertRepository.save(alert);
        return AlertDTO.toDTO(alert);

    }

    public List<Alert> getAll() {
        return alertRepository.findAll();
    }
}
