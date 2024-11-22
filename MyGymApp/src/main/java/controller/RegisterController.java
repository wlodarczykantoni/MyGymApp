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

    @PostMapping("/register")
    public String registerUser(User user, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        if (userRepository.existsByUsername(user.getUsername())) {
            model.addAttribute("error", "Username is already taken");
            return "register";
        }

        user.setSignupDate(LocalDate.now());
        userRepository.save(user);

        System.out.println("Zarejestrowano nowego użytkownika:");
        System.out.println("Username: " + user.getUsername());
        System.out.println("Signup Date: " + user.getSignupDate());

        return "redirect:/login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
}
