package hr.csa.backend.dto;

import hr.csa.backend.domain.Alert;
import hr.csa.backend.domain.ThreatLevel;

public class AlertDTO {

    private ThreatLevel threatLevel;

    private String message;

    public AlertDTO() {

    }

    public AlertDTO(ThreatLevel threatLevel, String message) {
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

    public static AlertDTO toDTO(Alert alert) {
        return new AlertDTO(alert.getThreatLevel(), alert.getMessage());

    }
}
