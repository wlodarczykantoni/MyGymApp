package controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import users.User;
import users.UserService;
import java.time.LocalDate;

@Controller
public class LoginController {

    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        logger.info("Displaying login form");
        return "login";
    }

    @GetMapping("/showRegisterForm")
    public String showRegistrationForm(Model model) {
        logger.info("Displaying registration form");
        User user = new User(); // Tworzymy pustego użytkownika
        user.setSignupDate(LocalDate.now()); // Ustawiamy datę rejestracji
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/processRegister")
    public String processRegistration(@ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error("Formularz ma błędy: " + bindingResult.getAllErrors());
            return "register";
        }

        try {
            userService.saveUser(user);
            logger.info("Użytkownik zarejestrowany: " + user.getUsername());
        } catch (Exception e) {
            logger.error("Błąd przy zapisie: ", e);
            return "register";
        }

        return "redirect:/login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        User user = userService.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("userId", user.getId());
            return user.isAdmin() ? "redirect:/admin/dashboard" : "redirect:/homePage";
        } else {
            model.addAttribute("error", "Błędny login lub hasło");
            return "login";
        }
    }
}