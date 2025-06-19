package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import users.User;
import users.UserService;

import java.util.List;

// Ten kontroler jest dla trenerów (adminów), żeby mogli zarządzać użytkownikami
@Controller
@RequestMapping("/admin")
public class AdminPanelController {

    private final UserService userService;

    @Autowired
    public AdminPanelController(UserService userService) {
        this.userService = userService; // Wstrzykujemy serwis do obsługi użytkowników
    }

    // Wyświetlanie panelu admina
    @GetMapping("/dashboard")
    public String adminDashboard(Model model) {
        List<User> userList = userService.getAllUsers(); // Bierzemy listę wszystkich użytkowników
        model.addAttribute("users", userList); // Przekazujemy ją do widoku
        return "adminPanel"; // Nazwa widoku HTML
    }

    // Szczegóły jednego użytkownika
    @GetMapping("/userDetails")
    public String viewUserDetails(@RequestParam Long userId, Model model) {
        User user = userService.getUserById(userId); // Pobieramy użytkownika po ID
        model.addAttribute("userId", userId); // Przekazujemy ID do widoku (tu można też dodać cały obiekt user)
        return "userDetails"; // Widok z detalami użytkownika
    }

    // Usuwanie użytkownika
    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam Long userId) {
        userService.deleteUser(userId); // Kasujemy użytkownika
        return "redirect:/admin/dashboard"; // Wracamy do panelu admina
    }
}
