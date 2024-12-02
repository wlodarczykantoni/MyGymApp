package training_plans;

import exercise.Exercise;
import jakarta.persistence.*;
import users.User;

import java.util.List;

@Entity
@Table(name = "training_plans")
public class TrainingPlans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long trainerId;
    private String title;
    private String level; // poziom trudności
    private String goals; // cel planu

    @ManyToOne
    @JoinColumn(name = "user_id", unique = true)
    public User user;

    @OneToMany(mappedBy = "trainingPlans", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlanExercise> planExercises;

    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<PlanExercise> getPlanExercises() {
        return planExercises;
    }

    public void setPlanExercises(List<PlanExercise> planExercises) {
        this.planExercises = planExercises;
    }
}
