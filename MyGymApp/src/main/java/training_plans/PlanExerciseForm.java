package training_plans;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PlanExerciseForm {
    @PostMapping("/saveData")
    public ResponseEntity<String> saveData(
            @RequestParam("planID") Long planID,
            @RequestParam("exerciseId") Long exerciseID,
            @RequestParam("sets") Integer sets ,
            @RequestParam("repetitions") Integer repetitions


    ) {

        System.out.println("Otrzymano dane: ");
        System.out.println("Plan ID: " + planID);
        System.out.println("Exercise ID: " + exerciseID);
        System.out.println("Sets: " + sets);
        System.out.println("Reoetitions: " + repetitions);


        return ResponseEntity.status(HttpStatus.CREATED).body("Dane zostały zapisane! Dziękujemy!" );
    }
}
