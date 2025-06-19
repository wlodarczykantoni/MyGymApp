package controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import users.UserService;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    // Główna strona (np. strona logowania)
    @GetMapping("/")
    public String index() {
        return "index"; // Pokazuje index.html
    }

    // Po zalogowaniu pokazuje ekran powitalny
    @GetMapping("/welcome")
    public String welcome(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId"); // Sprawdzamy kto jest zalogowany
        if (userId == null) {
            return "redirect:/"; // Jeśli nikogo nie ma, wracamy na start
        }

        String username = userService.getUserById(userId).getUsername(); // Pobieramy nazwę użytkownika
        model.addAttribute("username", username); // Przekazujemy do widoku
        return "welcome"; // Wyświetlamy welcome.html
    }

    // Wylogowanie – kończymy sesję
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Czyścimy dane sesji
        return "redirect:/"; // Wracamy na stronę główną
    }
}
