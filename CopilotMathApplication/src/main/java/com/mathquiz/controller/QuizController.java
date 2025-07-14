package com.mathquiz.controller;

import com.mathquiz.model.User;
import com.mathquiz.service.QuizService;
import com.mathquiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller for quiz functionality
 */
@Controller
@RequestMapping("/quiz")
public class QuizController {
    
    @Autowired
    private QuizService quizService;
    
    @Autowired
    private UserService userService;
    
    @GetMapping
    public String quizPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());
        
        model.addAttribute("user", user);
        model.addAttribute("settings", quizService.getActiveSettings());
        
        return "quiz";
    }
    
    @PostMapping("/start")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> startQuiz(
            @RequestParam String operationType,
            @RequestParam(defaultValue = "10") int questionCount) {
        
        try {
            List<QuizService.Question> questions = quizService.generateQuestions(operationType, questionCount);
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("questions", questions);
            response.put("settings", quizService.getActiveSettings());
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> error = new HashMap<>();
            error.put("success", false);
            error.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }
    
    @PostMapping("/submit")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> submitQuiz(
            @RequestBody Map<String, Object> quizData) {
        
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.findByUsername(auth.getName());
            
            // Process quiz results here
            // This would involve saving the quiz session and results
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Quiz submitted successfully!");
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> error = new HashMap<>();
            error.put("success", false);
            error.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }
}
