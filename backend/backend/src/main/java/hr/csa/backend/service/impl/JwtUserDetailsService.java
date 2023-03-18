package hr.csa.backend.service.impl;

import hr.csa.backend.domain.UserAccount;
import hr.csa.backend.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.security.core.authority.AuthorityUtils.commaSeparatedStringToAuthorityList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserAccountService accountService;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String mail) {
        UserAccount userAccount = accountService.findByMail(mail);
        if (userAccount == null) {
            throw new UsernameNotFoundException("Invalid username.");
        }else {
            String fetchedPass = userAccount.getPassword(); //ovdje ne mmogu raditi auth pass jer ga nemam
            return new User(mail, fetchedPass, authorities(mail));//authorities(emp)
        }
    }

//            if ("systemowner".equals(username)) {
//                return new User("systemowner", "$2a$12$wXO5u8WRWKMUA1y9XdHpbe5i4f0YDi1CLlIcBjqcTaugxt0RI0G5e", new ArrayList<>());
//            } else {
//                throw new UsernameNotFoundException("User not found with username: " + username);
//            }

    private List<GrantedAuthority> authorities(String mail) {
        UserAccount userAccount = accountService.findByMail(mail);
        if (userAccount.isAdministrator())
            return commaSeparatedStringToAuthorityList("ROLE_ADMINISTRATOR");
        else
            return commaSeparatedStringToAuthorityList("ROLE_USER");

    }
}