package hr.csa.backend.service.impl;

import hr.csa.backend.dao.ThreatIntelligenceRepository;
import hr.csa.backend.domain.ThreatLevel;
import hr.csa.backend.domain.ThreatIntelligence;
import hr.csa.backend.service.AlertService;
import hr.csa.backend.service.ThreatIntelligenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ThreatIntelligenceServiceJpa implements ThreatIntelligenceService {

    @Autowired
    private ThreatIntelligenceRepository threatIntelligenceRepository;

    @Autowired
    private AlertService alertService;

    private List<String> extensions = Stream.of(new String[]{
            ".pdf", ".txt", ".jpg", ".png", ".exe", ".ppt", ".docx", ".zip"
    }).collect(Collectors.toList());

    private Map<String, ThreatLevel> map = Stream.of(new Object[][]{
            {".pdf", ThreatLevel.LOW},
            {".txt", ThreatLevel.MEDIUM},
            {".jpg", ThreatLevel.LOW},
            {".png", ThreatLevel.LOW},
            {".exe", ThreatLevel.MEDIUM},
            {".ppt", ThreatLevel.HIGH},
            {".docx", ThreatLevel.LOW},
            {".zip", ThreatLevel.HIGH}
    }).collect(Collectors.toMap(p -> (String)p[0], p -> (ThreatLevel) p[1]));

    @Override
    public void generateRandom() {
        char[] array = new char[10];
        Random rnd = new Random();
        for(int i = 0; i < 10; i++){
             array[i] = (char) ('a' + rnd.nextInt(26));
        }
        String fileName = array.toString();

        int index = (int) Math.floor(Math.random()*8);
        String extension = extensions.get(index);
        String name = fileName + extension;
        ThreatLevel threatLevel = map.get(extension);
        long offset = Timestamp.valueOf("2012-01-01 00:00:00").getTime();
        long end = Timestamp.valueOf("2013-01-01 00:00:00").getTime();
        long diff = end - offset + 1;
        Timestamp rand = new Timestamp(offset + (long)(Math.random() * diff));
        ThreatIntelligence threatIntelligence = new ThreatIntelligence(threatLevel, name, rand.toLocalDateTime());
        threatIntelligenceRepository.save(threatIntelligence);
        alertService.createNewAlert(threatIntelligence);
        System.out.println(name);
    }

    @Override
    public List<ThreatIntelligence> getAll() {
        return threatIntelligenceRepository.findAll();
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
