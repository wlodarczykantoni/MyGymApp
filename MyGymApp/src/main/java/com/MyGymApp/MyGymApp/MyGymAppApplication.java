package com.MyGymApp.MyGymApp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import users.User;
import users.UserRepository;

import java.time.LocalDate;




@SpringBootApplication
@ComponentScan(basePackages = {"com.MyGymApp", "users"})
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

    public static MyGymAppApplication createMyGymAppApplication(UserRepository userRepository) {
        return new MyGymAppApplication(userRepository);
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

			log.info("findAll(), expect 3 users");
			log.info("-------------------------------");
			for (User user : userRepository.findAll()) {
				log.info(user.toString());
			}
			log.info("\n");
		};


		}
}