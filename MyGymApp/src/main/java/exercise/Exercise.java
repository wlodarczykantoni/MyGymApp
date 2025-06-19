package exercise;

import jakarta.persistence.*;
import training_plans.PlanExercise;
import java.util.List;

@Entity // Ta klasa to encja bazy danych (tabela exercises)
@Table(name = "exercises") // Nazwa tabeli w bazie
public class Exercise {

    @Id // Klucz główny
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto inkrementacja ID
    private Long id;

    private String name; // nazwa ćwiczenia
    private String description; // opis ćwiczenia
    private String muscleGroup; // grupa mięśniowa
    private String difficulty; // poziom trudności
    private String typeOfEquipment; // sprzęt potrzebny
    private String pictureExercise; // link/do zdjęcia ćwiczenia

    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL, orphanRemoval = true)
    // relacja 1 do wielu z PlanExercise — powiązane plany treningowe
    private List<PlanExercise> planExercises;

    // Gettery i Settery - potrzebne do odczytu i zapisu pól

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
