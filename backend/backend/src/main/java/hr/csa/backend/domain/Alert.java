package hr.csa.backend.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Alert {

    @Id
    @GeneratedValue
    private Long idAlert;

    private ThreatLevel threatLevel;

    private String message;

    public Alert() {

    }

    public Alert(ThreatLevel threatLevel, String message) {
        this.threatLevel = threatLevel;
        this.message = message;
    }

    public ThreatLevel getThreatLevel() {
        return threatLevel;
    }

    public void setThreatLevel(ThreatLevel threatLevel) {
        this.threatLevel = threatLevel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
