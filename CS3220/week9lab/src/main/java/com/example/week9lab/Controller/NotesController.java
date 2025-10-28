package com.example.week9lab.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NotesController {

    @GetMapping("/")
    public ModelAndView homePage() {
        return new ModelAndView("home");
    }
}
