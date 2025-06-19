package users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Metoda do wyszukiwania użytkownika po username
    User findByUsername(String username);

    // Sprawdza, czy username już istnieje
    boolean existsByUsername(String username);
}
