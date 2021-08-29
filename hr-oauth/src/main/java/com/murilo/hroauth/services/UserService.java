package com.murilo.hroauth.services;

import com.murilo.hroauth.Entites.User;
import com.murilo.hroauth.feignclients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class UserService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email){
        User user = userFeignClient.findByEmail(email).getBody();

        if(user == null){
            logger.error("Email not found " + email);
            throw  new IllegalArgumentException("not fount");
        }
        logger.info("Email found" + email);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userFeignClient.findByEmail(username).getBody();

        if(user == null){
            logger.error("Email not found " + username);
            throw  new UsernameNotFoundException("not fount");
        }
        logger.info("Email found" + username);
        return user;
    }
}
