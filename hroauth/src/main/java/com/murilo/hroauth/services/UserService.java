package com.murilo.hroauth.services;

import com.murilo.hroauth.Entites.User;
import com.murilo.hroauth.feignclients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email){
        User user = userFeignClient.findByEmail(email).getBody();

        if(Objects.isNull(user)){
            logger.error("Email not found " + email);
            throw  new IllegalArgumentException("not fount");
        }
        logger.info("Email found" + email);
        return user;
    }
}
