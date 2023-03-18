package hr.csa.backend.domain;

import org.springframework.aop.target.ThreadLocalTargetSource;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

public class ThreatIntelligence implements Serializable {

    @Id
    @GeneratedValue
    private Long idThreatIntelligence;

    private String level;
    private String name;
    private LocalDateTime dateTime;

    public ThreatIntelligence() {

    }

    public ThreatIntelligence(String level, String name, LocalDateTime dateTime) {
        this.level = level;
        this.name = name;
        this.dateTime = dateTime;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
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
