package hr.csa.backend.dao;

import hr.csa.backend.domain.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepository extends JpaRepository<Alert, Long> {



}
