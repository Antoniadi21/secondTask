package com.example.secondlab.Controllers;

import com.example.secondlab.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {
    UserService userService;

    public RegistrationController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String register(@RequestParam(name = "login") String login, @RequestParam(name = "password") String password,
                         @RequestParam(name = "repeatedPassword") String repeatedPassword,
                           @RequestParam(name = "email") String email, Model model) {
        //TODO Валидация

        if (!password.equals(repeatedPassword)) {
            model.addAttribute("passwordsDontMatch", "passwordsDontMatch");
            return "registration";
        } else if (userService.getByLogin(login) != null) {
            model.addAttribute("userWithThisLoginAlreadyExists", "userWithThisLoginAlreadyExists");
            return "registration";
        } else if (userService.getByEmail(email) != null) {
            model.addAttribute("userWithThisEmailAlreadyExists", "userWithThisEmailAlreadyExists");
            return "registration";
        } else {
            userService.save(login, email, password);
            return "login";
        }
    }
}
