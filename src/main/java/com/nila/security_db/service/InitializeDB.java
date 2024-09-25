package com.nila.security_db.service;

import com.nila.security_db.entity.User;
import com.nila.security_db.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class InitializeDB {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    InitializingBean sendDatabase() {
        return () -> {
            User user1 = User.builder()
                    .userName("kaviya")
                    .password(passwordEncoder.encode("kaviya"))
                    .enabled(true)
                    .roles("USER,ADMIN")
                    .build();
            userRepository.save(user1);
        };
    }
}
