package com.example.week8lab.Controller;

import com.example.week8lab.model.User;
import com.example.week8lab.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error, HttpSession session) {
        if (session.getAttribute("user") != null) {
            return new ModelAndView("redirect:/tickets");  // Redirect if already logged in
        }

        ModelAndView modelAndView = new ModelAndView("home");
        if (error != null) {
            modelAndView.addObject("error", "Invalid credentials, please try again.");
        }
        return modelAndView;
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session) {
        User user = userService.findByEmail(email); // Fetch user based on email

        if (user != null && user.getPassword().equals(password)) {
            // Check if the user is a technician and set their role accordingly
            if (email.equals("john@example.com") || email.equals("jane@example.com")) {
                user.setRole(User.Role.TECHNICIAN);  // Assign the technician role if the email matches
            } else {
                user.setRole(User.Role.USER);  // Default role for non-technician users
            }
            session.setAttribute("user", user);  // Store user in session
            return "redirect:/tickets";  // Redirect to tickets page after successful login
        }

        // If authentication fails, redirect to login with error
        return "redirect:/login?error=true";  // Include 'error' parameter in the URL
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();  // Invalidate the session on logout
        return "redirect:/login";  // Redirect to login page
    }
}
