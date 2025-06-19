package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import users.User;
import users.UserRepository;

import java.time.LocalDate;

@Controller
public class RegisterController {

    private final UserRepository userRepository;

    @Autowired
    public RegisterController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Obsługa rejestracji użytkownika
    @PostMapping("/register")
    public String registerUser(User user, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register"; // Jeśli są błędy w formularzu
        }

        if (userRepository.existsByUsername(user.getUsername())) {
            model.addAttribute("error", "Login już istnieje"); // Login zajęty
            return "register";
        }

        user.setSignupDate(LocalDate.now()); // Data rejestracji
        userRepository.save(user); // Zapis do bazy

        System.out.println("Zarejestrowano nowego użytkownika: " + user.getUsername());

        return "redirect:/login"; // Przekierowanie do logowania
    }

    // Formularz rejestracyjny
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User()); // Pusty użytkownik do formularza
        return "register";
    }
}
