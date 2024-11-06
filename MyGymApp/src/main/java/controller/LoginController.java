package controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        model.addAttribute("user", new User("", "", LocalDate.now())); // Inicjalizacja z pustymi wartościami
        return "register";
    }


    @PostMapping("/processRegister")
    public String processRegistration(@ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error("Registration form contains errors: " + bindingResult.getAllErrors());
            return "register";
        }

        try {
            userService.saveUser(user);
            logger.info("User successfully registered: " + user.getUsername());
        } catch (Exception e) {
            logger.error("Error saving user: ", e);
            return "register";
        }

        return "redirect:/login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        User user = userService.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("userId", user.getId());
            return user.isAdmin() ? "redirect:/adminPanel" : "redirect:/mainPage";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}
