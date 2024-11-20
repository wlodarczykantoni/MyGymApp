package training_plans;





import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TrainingPlansForm {
    @PostMapping("/saveData")
    public ResponseEntity<String> saveData(
            @RequestParam("id") Long id,
            @RequestParam("trainerId") Long trainerId,
            @RequestParam("userId") Long userId,
            @RequestParam("title") String title,
            @RequestParam("level") String level,
            @RequestParam("goals") String goals



            ) {

        System.out.println("Otrzymano dane: ");
        System.out.println("Id: " + id);
        System.out.println("Trainer Id: " + trainerId);
        System.out.println("User Id: " + userId);
        System.out.println("Title: " + title);
        System.out.println("Level: " + level);
        System.out.println("Goals: " + goals);



        return ResponseEntity.status(HttpStatus.CREATED).body("Dane zostały zapisane! Dziękujemy!" );
    }
}
