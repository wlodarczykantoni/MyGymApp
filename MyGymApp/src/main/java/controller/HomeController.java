package controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import users.UserService;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        boolean authenticated = userService.checkLogin(username, password);
        if (authenticated) {
            session.setAttribute("userId", userService.findByUsername(username).getId());
            return "redirect:/welcome";
        } else {
            return "redirect:/?error=Nieprawidłowe dane logowania";
        }
    }

    @GetMapping("/welcome")
    public String welcome(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }
        String username = userService.getUserById(userId).getUsername();
        model.addAttribute("username", username);
        return "welcome";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
