package training_plans;

import exercise.Exercise;
import jakarta.persistence.*;

@Entity
@Table(name = "planExercise")
public class PlanExercise {
    @Id
    private Long planId;
    private Long exerciseId;
    private Integer sets;
    private Integer repetitions;

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(Integer repetitions) {
        this.repetitions = repetitions;
    }

    public Integer getSets() {
        return sets;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }

    public Long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    private Integer weight;

    public void setId(Long planId) {
        this.planId = planId;
    }

    public Long getId() {
        return planId;
    }

    @ManyToOne
    @JoinColumn(name = "trainingPlan_id",nullable = false)
    private TrainingPlans trainingPlans;
    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    public TrainingPlans getTrainingPlans() {
        return trainingPlans;
    }

    public void setTrainingPlans(TrainingPlans trainingPlans) {
        this.trainingPlans = trainingPlans;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }




}
