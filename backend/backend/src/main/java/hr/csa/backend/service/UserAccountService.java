package hr.csa.backend.service;

import hr.csa.backend.domain.UserAccount;
import hr.csa.backend.dto.LoginDTO;
import hr.csa.backend.dto.OneTimeCodeDTO;
import hr.csa.backend.dto.UserDTO;

import java.util.List;

public interface UserAccountService {
    UserDTO registerUser(UserDTO userDTO);

    UserDTO loginUser(LoginDTO loginDTO);

    UserDTO confirmLogin(String code, Long idUserAccount);

    //void createAdmins();

    UserAccount findByMail(String mail);

    List<UserAccount> getAll();

    void deleteUser(Long idUserAccount);
}
