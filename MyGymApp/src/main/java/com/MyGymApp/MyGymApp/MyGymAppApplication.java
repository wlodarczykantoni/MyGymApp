package com.MyGymApp.MyGymApp;

import users.User;
import users.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.time.LocalDate;

@SpringBootApplication
@ComponentScan(basePackages = {"com.MyGymApp.MyGymApp", "users", "controller"})
@EnableJpaRepositories(basePackages = {"users", "trophies", "training_plans", "exercise"})
@EntityScan(basePackages = {"users", "trophies", "training_plans", "exercise"})
public class MyGymAppApplication {

	private static final Logger log = LoggerFactory.getLogger(MyGymAppApplication.class);

	private final UserRepository userRepository;

	@Autowired
	public MyGymAppApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MyGymAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDemoDb() {
		return (args) -> {
			User admin = new User("admin", "admin", LocalDate.now());
			admin.setAdmin(true);

			User user1 = new User("Antek", "password", LocalDate.of(2023, 11, 10));
			User user2 = new User("randomUser", "password", LocalDate.of(2023, 5, 5));

			userRepository.save(admin);
			userRepository.save(user1);
			userRepository.save(user2);

			log.info("Zapisani użytkownicy:");
			for (User user : userRepository.findAll()) {
				log.info(user.toString());
			}
		};
	}
}