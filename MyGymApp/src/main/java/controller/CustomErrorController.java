package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//jest kontrolerem obsługującym niestandardowe błędy aplikacji, przekierowując użytkownika na odpowiednie widoki błędów w zależności od otrzymanego kodu błędu HTTP

@Controller
public class CustomErrorController implements ErrorController {

    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error-404";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error-500";
            }
        }


        String message = request.getParameter("message");
        if (message != null && !message.isEmpty()) {
            model.addAttribute("errorMessage", message);
            return "error";
        }

        return "error";
    }


    @GetMapping("/error")
    public String showErrorPage(@RequestParam String message, Model model) {
        model.addAttribute("errorMessage", message);
        return "error";
    }
}