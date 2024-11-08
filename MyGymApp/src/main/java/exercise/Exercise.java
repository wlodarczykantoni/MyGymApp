package exercise;


import jakarta.persistence.*;
import training_plans.PlanExercise;
import training_plans.TrainingPlans;

import java.util.List;

@Entity
@Table(name = "exercises")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String muscleGroup;
    private String difficulty;
    private String typeOfEquipment;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMuscleGroup() {
        return muscleGroup;
    }

    public void setMuscleGroup(String muscleGroup) {
        this.muscleGroup = muscleGroup;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getTypeOfEquipment() {
        return typeOfEquipment;
    }

    public void setTypeOfEquipment(String typeOfEquipment) {
        this.typeOfEquipment = typeOfEquipment;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @OneToMany(mappedBy = "exercises", cascade = CascadeType.ALL)
    private List<PlanExercise> planExercises;


    public List<PlanExercise> getPlanExercises() {
        return planExercises;
    }

    public void setPlanExercises(List<PlanExercise> planExercises) {
        this.planExercises = planExercises;
    }







}
