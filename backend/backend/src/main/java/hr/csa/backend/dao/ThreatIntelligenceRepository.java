package hr.csa.backend.dao;

import hr.csa.backend.domain.ThreatIntelligence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThreatIntelligenceRepository extends JpaRepository<ThreatIntelligence, Long> {
}
