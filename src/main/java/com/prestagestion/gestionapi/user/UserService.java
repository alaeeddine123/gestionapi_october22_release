package com.prestagestion.gestionapi.user;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.Optional;

@Transactional
@Data
@Service
public class UserService implements UserDetailsService {

    private final static String USER_NOT_FOUND = " username %s not found ";

    @Autowired
    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() ->
                        new UsernameNotFoundException(String.format(USER_NOT_FOUND, email)));
    }


}



