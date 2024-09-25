package com.nila.security_db;

import com.nila.security_db.entity.User;
import com.nila.security_db.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SecurityDbApplication {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SecurityDbApplication.class, args);
	}

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
