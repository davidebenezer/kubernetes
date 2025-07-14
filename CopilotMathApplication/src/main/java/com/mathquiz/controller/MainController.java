package com.mathquiz.controller;

import com.mathquiz.model.User;
import com.mathquiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Main controller for authentication and basic pages
 */
@Controller
public class MainController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public String home() {
        return "index";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/register")
    public String register() {
        return "register";
    }
    
    @PostMapping("/register")
    public String registerUser(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String fullName,
            @RequestParam Integer age,
            @RequestParam Integer grade,
            Model model) {
        
        try {
            if (!userService.isUsernameAvailable(username)) {
                model.addAttribute("error", "Username already exists!");
                return "register";
            }
            
            userService.registerUser(username, password, fullName, age, grade);
            model.addAttribute("success", "Registration successful! Please login.");
            return "login";
        } catch (Exception e) {
            model.addAttribute("error", "Registration failed: " + e.getMessage());
            return "register";
        }
    }
    
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());
        
        model.addAttribute("user", user);
        model.addAttribute("isAdmin", user.getRole() == User.Role.ADMIN);
        
        return "dashboard";
    }
}
