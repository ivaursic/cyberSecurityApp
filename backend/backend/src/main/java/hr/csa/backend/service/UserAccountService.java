package hr.csa.backend.service;

import hr.csa.backend.domain.UserAccount;
import hr.csa.backend.dto.LoginDTO;
import hr.csa.backend.dto.OneTimeCodeDTO;
import hr.csa.backend.dto.UserDTO;

public interface UserAccountService {
    UserDTO registerUser(UserDTO userDTO);

    UserDTO loginUser(LoginDTO loginDTO);

    UserDTO confrimLogin(OneTimeCodeDTO oneTimeCodeDTO, Long idUserAccount);

    UserAccount findByMail(String mail);

    // void createAdmins();
}
