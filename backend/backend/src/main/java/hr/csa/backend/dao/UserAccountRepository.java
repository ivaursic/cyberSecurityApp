package hr.csa.backend.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.csa.backend.domain.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

}

