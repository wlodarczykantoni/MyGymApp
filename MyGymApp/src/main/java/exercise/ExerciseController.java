package exercise;

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

    // Pokazuje formularz do dodania nowego ćwiczenia
    @GetMapping("/add-exercise")
    public String showForm(Model model) {
        model.addAttribute("exercise", new Exercise()); // tworzymy pusty obiekt do formularza
        return "add-exercise"; // nazwa widoku HTML (thymeleaf itp.)
    }

    // Obsługuje przesłanie formularza i zapisuje ćwiczenie do bazy
    @PostMapping("/add-exercise")
    public String addExercise(@ModelAttribute Exercise exercise) {
        System.out.println("Dodawanie ćwiczenia: " + exercise);
        exerciseRepository.save(exercise); // zapisujemy obiekt do bazy
        return "redirect:/exercises"; // po dodaniu przekieruj na listę ćwiczeń
    }

    // Pokazuje listę wszystkich ćwiczeń z bazy
    @GetMapping("/exercises")
    public String listExercises(Model model) {
        System.out.println("Pobieranie ćwiczen: " + exerciseRepository.findAll());
        model.addAttribute("exercises", exerciseRepository.findAll()); // dodaj listę do modelu
        return "exercise-list"; // widok pokazujący listę
    }
}
