package users;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import training_plans.TrainingPlans;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private boolean admin;
    private LocalDate signupDate;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserProfile profile;

    @OneToMany(mappedBy = "user")
    private List<TrainingPlans> plans;

    // Konstruktor bezargumentowy (wymagany przez JPA)
    public User() {
    }

    // Konstruktor z parametrami
    public User(String username, String password, LocalDate signupDate) {
        this.username = username;
        this.password = password;
        this.signupDate = signupDate;
        this.admin = false; // Domyślnie użytkownik nie jest adminem
    }

    // Gettery i settery
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public LocalDate getSignupDate() {
        return signupDate;
    }

    public void setSignupDate(LocalDate signupDate) {
        this.signupDate = signupDate;
    }

    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }

    public List<TrainingPlans> getPlans() {
        return plans;
    }

    public void setPlans(List<TrainingPlans> plans) {
        this.plans = plans;
    }
}