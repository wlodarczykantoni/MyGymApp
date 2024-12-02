package exercise;

import jakarta.persistence.*;
import training_plans.PlanExercise;

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
    private String pictureExercise;

    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlanExercise> planExercises;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getPictureExercise() {
        return pictureExercise;
    }

    public void setPictureExercise(String pictureExercise) {
        this.pictureExercise = pictureExercise;
    }

    public List<PlanExercise> getPlanExercises() {
        return planExercises;
    }

    public void setPlanExercises(List<PlanExercise> planExercises) {
        this.planExercises = planExercises;
    }
}
