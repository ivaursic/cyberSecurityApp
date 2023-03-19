package hr.csa.backend.dto;

import hr.csa.backend.domain.Alert;
import hr.csa.backend.domain.ThreatIntelligence;
import hr.csa.backend.domain.ThreatLevel;

import java.time.LocalDateTime;

public class ThreatDTO {
    private String name;
    private ThreatLevel level;
    private LocalDateTime date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ThreatLevel getLevel() {
        return level;
    }

    public void setLevel(ThreatLevel level) {
        this.level = level;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public ThreatDTO(String name, ThreatLevel level, LocalDateTime date) {
        this.name = name;
        this.level = level;
        this.date = date;
    }

    public static ThreatDTO toDTO(ThreatIntelligence threat) {
        return new ThreatDTO(threat.getName(), threat.getLevel(), threat.getDateTime());

    }
}
