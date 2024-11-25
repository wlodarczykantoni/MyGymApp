package training_plans;

import exercise.Exercise;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "trainingPlans")
public class TrainingPlans {
    @Id
    private Long id;
    private Long trainerId;
    private Long userId;
    private String title;
    private String level;//poziom trudnosci
    private String goals;//cel planu

    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    @ManyToMany
    @JoinTable(
            name = "trainingPlans",
            joinColumns = @JoinColumn(name = "plan_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id")
    )
    private List<Exercise> exercises;

    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL)
    private List<PlanExercise> planExercises;

    public List<Exercise> getExercises() {
        return exercises;
    }


    public List<PlanExercise> getPlanExercises() {
        return planExercises;
    }

    public void setPlanExercises(List<PlanExercise> planExercises) {
        this.planExercises = planExercises;
    }


    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}