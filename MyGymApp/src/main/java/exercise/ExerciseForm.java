package exercise;




import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ExerciseForm {
    @PostMapping("/saveData")
    public ResponseEntity<String> saveData(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("muscleGroup") String muscleGroup,
            @RequestParam("diffficulty") String difficulty,
            @RequestParam("typeOfEquipment") String typeOfEquipment


    ) {

        System.out.println("Otrzymano dane: ");
        System.out.println("Nazwa: " + name);
        System.out.println("Opis: " + description);
        System.out.println("Muscle group: " + muscleGroup);
        System.out.println("Difficulty: " + difficulty);
        System.out.println("Type of equipment: " + typeOfEquipment);


        return ResponseEntity.status(HttpStatus.CREATED).body("Dane zostały zapisane! Dziękujemy!" );
    }
}
