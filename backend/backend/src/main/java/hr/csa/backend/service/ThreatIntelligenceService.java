package hr.csa.backend.service;


import hr.csa.backend.domain.ThreatIntelligence;

import java.util.Date;
import java.util.List;

public interface ThreatIntelligenceService {

    List<ThreatIntelligence> getAll();

    List<ThreatIntelligence> getByLevel(String level);

    List<ThreatIntelligence> getByDate(Date date);
}
