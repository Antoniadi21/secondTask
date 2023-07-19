package com.example.secondlab.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/error")
public class ErrorController {
    @GetMapping
    public ModelAndView error() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        mv.getModel().put("data", "пупупу");

        return mv;
    }
}
