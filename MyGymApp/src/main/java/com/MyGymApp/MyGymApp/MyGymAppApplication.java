package com.MyGymApp.MyGymApp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import users.User;
import users.UserRepository;

@SpringBootApplication
public class MyGymAppApplication {

	private static final Logger log = LoggerFactory.getLogger(MyGymAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MyGymAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDemoDb(UserRepository userRepository) {
		return (args) -> {
			User admin = new User("admin", "admin_password");
			User user1 = new User("Antek", "password1");
			User user2 = new User("randomUser", "password2");

			userRepository.save(admin);
			userRepository.save(user1);
			userRepository.save(user2);

			log.info("findAll(), expect 3 users");
			log.info("-------------------------------");
			for (User user : userRepository.findAll()) {
				log.info(user.toString());
			}
			log.info("\n");
		};
	}
}
