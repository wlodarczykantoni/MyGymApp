package users;

import jakarta.persistence.*;
import training_plans.PlanExercise;
import training_plans.TrainingPlans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//reprezentuje użytkownika w systemie ma pola takie jak id, username, signupDate, password i admin oraz listę zegarów (clocks). metoda addClock dodaje zegar użytkownikowi, a removeClock usuwa go kluczowe są adnotacje JPA użyte do mapowania klasy na tabelę w bazie danych

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private LocalDate signupDate;

    private String password;

    private boolean admin;

    public User() {}

    public User(String username, String password, LocalDate signupDate) {
        this.username = username;
        this.password = password;
        this.signupDate = signupDate;
    }

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

    public LocalDate getSignupDate() {
        return signupDate;
    }

    public void setSignupDate(LocalDate signupDate) {
        this.signupDate = signupDate;
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




    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<TrainingPlans> plans = new ArrayList<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserProfile profile;

    public List<TrainingPlans> getPlans() {
        return plans;
    }

    public void setPlans(List<TrainingPlans> plans) {
        this.plans = plans;
    }



    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }





    @Override
    public String toString() {
        return "User [" + id + "] has username: " + username;
    }
}