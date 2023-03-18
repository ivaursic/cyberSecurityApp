package hr.csa.backend.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.csa.backend.domain.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    int countByMail(String mail);

    UserAccount getById(Long id);

    Optional<UserAccount> findByMail(String mail);

    UserAccount getByIdUserAccount(Long idUserAccount);
}

