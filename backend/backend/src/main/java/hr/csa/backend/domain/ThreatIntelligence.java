package hr.csa.backend.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class ThreatIntelligence implements Serializable {

    @Id
    @GeneratedValue
    private Long idThreatIntelligence;

    private ThreatLevel level;
    private String name;
    private LocalDateTime dateTime;

    public ThreatIntelligence() {
    }

    public ThreatIntelligence(ThreatLevel level, String name, LocalDateTime dateTime) {
        super();
        this.level = level;
        this.name = name;
        this.dateTime = dateTime;
    }

    public ThreatLevel getLevel() {
        return level;
    }

    public void setLevel(ThreatLevel level) {
        this.level = level;
    }

    public Long getIdThreatIntelligence() {
        return idThreatIntelligence;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
