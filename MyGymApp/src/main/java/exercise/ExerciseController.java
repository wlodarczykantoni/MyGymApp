package exercise;


import exercise.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ExerciseController {

    @Autowired
    private ExerciseRepository exerciseRepository;


    @GetMapping("/add-exercise")
    public String showForm(Model model) {
        model.addAttribute("exercise", new Exercise());
        return "add-exercise";
    }

    @PostMapping("/add-exercise")
    public String addExercise(@ModelAttribute Exercise exercise) {
        System.out.println("Dodawanie ćwiczenia: " + exercise);
        exerciseRepository.save(exercise);
        return "redirect:/exercises";
    }

    @GetMapping("/exercises")
    public String listExercises(Model model) {
        System.out.println("Pobieranie ćwiczen: " + exerciseRepository.findAll());
        model.addAttribute("exercises", exerciseRepository.findAll());
        return "exercise-list";
    }
}
