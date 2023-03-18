package hr.csa.backend.service.impl;

import hr.csa.backend.dao.UserAccountRepository;
import hr.csa.backend.domain.*;
import hr.csa.backend.service.*;
import hr.csa.backend.exception.*;

import hr.csa.backend.dto.LoginDTO;
import hr.csa.backend.dto.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
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
        userAccount.setAdministrator(false);
        accountRepo.save(userAccount);
        return UserDTO.toDTO(userAccount);
    }

    @Override
    public UserDTO loginUser(LoginDTO loginDTO) {
        UserAccount userAccount = new UserAccount();
        userAccount = findByMail(loginDTO.getMail());
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
    public UserDTO confirmLogin(String code, Long idUserAccount) {
        UserAccount userAccount = accountRepo.getByIdUserAccount(idUserAccount);
        String inputCode = code;
        System.out.println("uslo");
        if(!inputCode.equals(userAccount.getMfaOneTimePassword())){
            //TODO napravi iznimku
            throw new RuntimeException("Wrong code!!!");
        }
        return UserDTO.toDTO(userAccount);
    }

    @Override
    public UserAccount findByMail(String mail) {
        return accountRepo.findByMail(mail).orElseThrow(() -> new ResourceNotFoundException("nema"));
    }


    private String sendCodeViaMail(UserAccount userAccount){
        SimpleMailMessage msg = new SimpleMailMessage();
        String code = String.valueOf((int) Math.floor(Math.random()*(999999-100000+1) + 100000));
        //TODO mail s kojeg cemo slat mailove
        msg.setFrom("kokeferencija7@gmail.com");
        msg.setSubject("Login to your CyberSecurityApp");
        msg.setText("Hi " + userAccount.getFirstName() + " " + userAccount.getLastName()
                + " \nYour onetime login code for CyberSecurityApp is:\n" + code);
        msg.setTo(userAccount.getMail());
        javaMailSender.send(msg);
        return code;
    }

//    @Override
//    public void createAdmins() {
////        try{
////            findByMail("lucija.domic@fer.hr");
////        } catch (Exception e) {
//            UserAccount luceAdmin = new UserAccount("lucija.domic@fer.hr", bcryptEncoder.encode("12345678"), "Lucija", "Domić");
//            UserAccount nixAdmin = new UserAccount("nikoleta.benic@fer.hr", bcryptEncoder.encode("12345678"), "Nikoleta", "Benić");
//            UserAccount josyUser = new UserAccount("josipa.markic@fer.hr", bcryptEncoder.encode("12345678"), "Josipa", "Markić");
//            UserAccount ivaUser = new UserAccount("iva.ursic@fer.hr", bcryptEncoder.encode("12345678"), "Iva", "Ursić");
//
//            luceAdmin.setAdministrator(true);
//            nixAdmin.setAdministrator(true);
//            josyUser.setAdministrator(false);
//            ivaUser.setAdministrator(false);
//
//            accountRepo.save(luceAdmin);
//            System.out.println("Luce spremljena");
//            accountRepo.save(nixAdmin);
//            accountRepo.save(josyUser);
//            accountRepo.save(ivaUser);
//       // }
//    }

}
