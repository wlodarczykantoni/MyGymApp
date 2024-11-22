package controller;


import com.MyGymApp.MyGymApp.MyGymAppApplication;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import training_plans.TrainingPlans;
import users.User;
import users.UserProfile;
import users.UserService;

import java.util.List;


@Controller
public class MainPageController {

    @Autowired
    private UserService userService;


    @GetMapping("/homePage")
    public String showMainWebPage(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }

        User user = userService.getUserById(userId);
        if (user == null) {
            return "redirect:/login";
        }


        List<TrainingPlans> userPlans = user.getPlans();
        model.addAttribute("userPlans", userPlans);


        UserProfile profile = user.getProfile();
        model.addAttribute("userProfile", profile);

        return "mainWeb";
    }

}