package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import users.User;
import users.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminPanelController {

    private final UserService userService;

    @Autowired
    public AdminPanelController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/dashboard")
    public String adminDashboard(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users", userList);
        return "adminPanel";
    }


    @GetMapping("/userDetails")
    public String viewUserDetails(@RequestParam Long userId, Model model) {
        User userID = userService.getUserById(userId);
        model.addAttribute("userId", userId);
        return "userDetails";
    }


    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam Long userId) {
        userService.deleteUser(userId);
        return "redirect:/admin/dashboard";
    }





}