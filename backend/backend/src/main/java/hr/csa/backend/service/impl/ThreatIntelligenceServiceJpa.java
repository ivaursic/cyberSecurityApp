package hr.csa.backend.service.impl;

import hr.csa.backend.dao.ThreatIntelligenceRepository;
import hr.csa.backend.domain.ThreatIntelligence;
import hr.csa.backend.service.ThreatIntelligenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ThreatIntelligenceServiceJpa implements ThreatIntelligenceService {

    @Autowired
    private ThreatIntelligenceRepository threatRepo;
    @Override
    public List<ThreatIntelligence> getAll() {
        return threatRepo.findAll();
    }

    @Override
    public List<ThreatIntelligence> getByLevel(String level) {
        return getAll().stream()
                .filter(th -> th.getLevel().equals(level))
                .collect(Collectors.toList());

    }

    @Override
    public List<ThreatIntelligence> getByDate(Date date) {
        return getAll().stream()
                .filter(th -> th.getDateTime().equals(date))
                .collect(Collectors.toList());

    }
}
