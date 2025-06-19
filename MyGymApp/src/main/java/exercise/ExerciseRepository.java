package exercise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Interfejs do operacji na bazie danych (CRUD dla Exercise)
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    // nie trzeba nic pisać, JpaRepository ma wszystko co potrzebne
}
