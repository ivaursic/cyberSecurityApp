package hr.csa.backend.service;

import hr.csa.backend.domain.Alert;
import hr.csa.backend.domain.ThreatIntelligence;
import hr.csa.backend.dto.AlertDTO;

import java.util.List;

public interface AlertService {


    AlertDTO createNewAlert(ThreatIntelligence threat);

    public List<Alert> getAll();
}
