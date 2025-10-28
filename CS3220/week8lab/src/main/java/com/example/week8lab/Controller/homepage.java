package com.example.week8lab.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class homepage {
    @GetMapping("/")
    public ModelAndView homePage() {
        return new ModelAndView("home");
    }
}
