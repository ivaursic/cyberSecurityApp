package hr.csa.backend.service.impl;

import hr.csa.backend.dao.UserAccountRepository;
import hr.csa.backend.domain.UserAccount;
import hr.csa.backend.dto.LoginDTO;
import hr.csa.backend.dto.OneTimeCodeDTO;
import hr.csa.backend.dto.UserDTO;
import hr.csa.backend.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.mail.javamail.JavaMailSender;

public class UserAccountServiceJpa implements UserAccountService {

    @Autowired
    private UserAccountRepository accountRepo;
    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        if(userDTO.getFirstName() == null || userDTO.getLastName() == null || userDTO.getMail() == null || userDTO.getPassword() == null){
            //TODO napravi iznimku
            throw new RuntimeException();
        }
        UserAccount userAccount = new UserAccount(userDTO.getMail(), bcryptEncoder.encode(userDTO.getPassword()), userDTO.getFirstName(), userDTO.getLastName());
        accountRepo.save(userAccount);
        return UserDTO.toDTO(userAccount);
    }

    @Override
    public UserDTO loginUser(LoginDTO loginDTO) {
        UserAccount userAccount = new UserAccount();
        userAccount = accountRepo.findByMail(loginDTO.getMail());
        if (!bcryptEncoder.matches(loginDTO.getPassword(), userAccount.getPassword())) {
            //TODO napravi iznimku
            throw new RuntimeException("Wrong username or password");
        }
        String oneTimeCode = sendCodeViaMail(userAccount);
        userAccount.setMfaOneTimePassword(oneTimeCode);
        accountRepo.save(userAccount);
        return UserDTO.toDTO(userAccount);
    }

    @Override
    public UserDTO confrimLogin(OneTimeCodeDTO oneTimeCodeDTO, Long idUserAccount) {
        UserAccount userAccount = accountRepo.getByIdUserAccount(idUserAccount);
        String inputCode = oneTimeCodeDTO.getCode();
        if(!inputCode.equals(userAccount.getMfaOneTimePassword())){
            //TODO napravi iznimku
            throw new RuntimeException("Wrong code!!!");
        }
        return UserDTO.toDTO(userAccount);
    }

    private String sendCodeViaMail(UserAccount userAccount){
        SimpleMailMessage msg = new SimpleMailMessage();
        String code = String.valueOf(Math.floor(Math.random()*(999999-100000+1) + 100000));
        //TODO mail s kojeg cemo slat mailove
        msg.setFrom("motomoto@gmail.com");
        msg.setSubject("Email address confirmation");
        msg.setText("Hi " + userAccount.getFirstName() + " " + userAccount.getLastName()
                + " \nYour onetime login code for CyberSecurityApp is:\n" + code);
        msg.setTo(userAccount.getMail());
        javaMailSender.send(msg);
        return code;
    }
}
