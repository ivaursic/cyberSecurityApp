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

    private String description;



}
