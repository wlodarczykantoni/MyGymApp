package exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // To jest REST controller - zwraca JSON, nie HTML
@RequestMapping("/api") // bazowy URL dla tego kontrolera
public class ExerciseForm {

    @Autowired
    private ExerciseRepository exerciseRepository; // wstrzykujemy repozytorium, żeby zapisać do bazy

    // Metoda przyjmuje dane z formularza (np. z JS), zapisuje do bazy i zwraca status
    @PostMapping("/saveData/exercisesAtlas")
    public ResponseEntity<String> saveData(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("muscleGroup") String muscleGroup,
            @RequestParam("difficulty") String difficulty,
            @RequestParam("typeOfEquipment") String typeOfEquipment) {

        System.out.println("Otrzymano dane: ");
        System.out.println("Nazwa: " + name);
        System.out.println("Opis: " + description);
        System.out.println("Muscle group: " + muscleGroup);
        System.out.println("Difficulty: " + difficulty);
        System.out.println("Type of equipment: " + typeOfEquipment);

        // Tworzymy nowy obiekt Exercise i ustawiamy mu pola z requesta
        Exercise exercise = new Exercise();
        exercise.setName(name);
        exercise.setDescription(description);
        exercise.setMuscleGroup(muscleGroup);
        exercise.setDifficulty(difficulty);
        exercise.setTypeOfEquipment(typeOfEquipment);

        // Zapis do bazy
        exerciseRepository.save(exercise);

        // Zwracamy status 201 Created i wiadomość JSON
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("{\"message\":\"Dane zostały zapisane! Dziękujemy!\"}");
    }
}
