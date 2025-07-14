package com.mathquiz.controller;

import com.mathquiz.model.QuizSettings;
import com.mathquiz.service.QuizService;
import com.mathquiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for admin functionality
 */
@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    
    @Autowired
    private QuizService quizService;
    
    @Autowired
    private UserService userService;
    
    @GetMapping
    public String adminDashboard(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("settings", quizService.getActiveSettings());
        return "admin/dashboard";
    }
    
    @GetMapping("/settings")
    public String settingsPage(Model model) {
        model.addAttribute("settings", quizService.getActiveSettings());
        return "admin/settings";
    }
    
    @PostMapping("/settings")
    public String updateSettings(
            @RequestParam Integer timeoutSeconds,
            @RequestParam Integer maxBreaks,
            @RequestParam Integer breakDurationMinutes,
            @RequestParam Integer questionsPerSession,
            @RequestParam(required = false) Boolean allowAddition,
            @RequestParam(required = false) Boolean allowSubtraction,
            @RequestParam(required = false) Boolean allowMultiplication,
            @RequestParam(required = false) Boolean allowDivision,
            @RequestParam Integer minNumber,
            @RequestParam Integer maxNumber,
            Model model) {
        
        try {
            QuizSettings settings = new QuizSettings();
            settings.setTimeoutSeconds(timeoutSeconds);
            settings.setMaxBreaks(maxBreaks);
            settings.setBreakDurationMinutes(breakDurationMinutes);
            settings.setQuestionsPerSession(questionsPerSession);
            settings.setAllowAddition(allowAddition != null && allowAddition);
            settings.setAllowSubtraction(allowSubtraction != null && allowSubtraction);
            settings.setAllowMultiplication(allowMultiplication != null && allowMultiplication);
            settings.setAllowDivision(allowDivision != null && allowDivision);
            settings.setMinNumber(minNumber);
            settings.setMaxNumber(maxNumber);
            
            quizService.updateQuizSettings(settings);
            model.addAttribute("success", "Settings updated successfully!");
        } catch (Exception e) {
            model.addAttribute("error", "Failed to update settings: " + e.getMessage());
        }
        
        model.addAttribute("settings", quizService.getActiveSettings());
        return "admin/settings";
    }
}
