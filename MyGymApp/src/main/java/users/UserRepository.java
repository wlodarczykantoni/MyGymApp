package users;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
@SpringBootApplication
@EnableJpaRepositories(basePackages = "users")
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
    boolean existsByUsername(String username);
}
