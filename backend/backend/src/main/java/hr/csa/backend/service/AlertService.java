package hr.csa.backend.service;

import hr.csa.backend.domain.ThreatIntelligence;
import hr.csa.backend.dto.AlertDTO;

public interface AlertService {


    AlertDTO createNewAlert(ThreatIntelligence threat);
}
