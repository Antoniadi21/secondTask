package com.example.secondlab.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {


    @GetMapping("/auth/log")
    public String login() {
        return "login";
    }

/*    @PostMapping("/registration")
    public String register(@RequestBody String login, @RequestBody String password,
                           @RequestBody String repeatedPassword,
                           @RequestBody String email, Model model) {
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
    }*/
}
