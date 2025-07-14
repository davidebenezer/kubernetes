package com.mathquiz.service;

import com.mathquiz.model.*;
import com.mathquiz.repository.QuizSessionRepository;
import com.mathquiz.repository.QuizSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Service for quiz logic and question generation
 */
@Service
@Transactional
public class QuizService {
    
    @Autowired
    private QuizSessionRepository quizSessionRepository;
    
    @Autowired
    private QuizSettingsRepository quizSettingsRepository;
    
    /**
     * Generate quiz questions based on settings
     */
    public List<Question> generateQuestions(String operationType, int count) {
        QuizSettings settings = getActiveSettings();
        List<Question> questions = new ArrayList<>();
        Random random = new Random();
        
        for (int i = 0; i < count; i++) {
            int num1 = random.nextInt(settings.getMaxNumber() - settings.getMinNumber() + 1) + settings.getMinNumber();
            int num2 = random.nextInt(settings.getMaxNumber() - settings.getMinNumber() + 1) + settings.getMinNumber();
            
            Question question = switch (operationType.toLowerCase()) {
                case "addition" -> new Question(num1, num2, "+", num1 + num2);
                case "subtraction" -> {
                    // Ensure positive result
                    if (num1 < num2) {
                        int temp = num1;
                        num1 = num2;
                        num2 = temp;
                    }
                    yield new Question(num1, num2, "-", num1 - num2);
                }
                case "multiplication" -> new Question(num1, num2, "×", num1 * num2);
                case "division" -> {
                    // Ensure whole number division
                    int product = num1 * num2;
                    yield new Question(product, num1, "÷", num2);
                }
                default -> new Question(num1, num2, "+", num1 + num2);
            };
            
            questions.add(question);
        }
        
        return questions;
    }
    
    /**
     * Save quiz session results
     */
    public QuizSession saveQuizSession(User user, String operationType, List<QuestionResult> results) {
        QuizSession session = new QuizSession(user, operationType);
        session.setTotalQuestions(results.size());
        session.setCorrectAnswers((int) results.stream().mapToLong(r -> r.getIsCorrect() ? 1 : 0).sum());
        session.setTotalTimeSeconds(results.stream().mapToLong(QuestionResult::getTimeTakenSeconds).sum());
        
        session = quizSessionRepository.save(session);
        
        // Set session reference for all results
        for (QuestionResult result : results) {
            result.setQuizSession(session);
        }
        
        return session;
    }
    
    /**
     * Get user's quiz history
     */
    public List<QuizSession> getUserQuizHistory(User user) {
        return quizSessionRepository.findByUserOrderByCreatedAtDesc(user);
    }
    
    /**
     * Get active quiz settings
     */
    public QuizSettings getActiveSettings() {
        return quizSettingsRepository.findByIsActiveTrue()
                .orElse(new QuizSettings()); // Return default settings if none found
    }
    
    /**
     * Update quiz settings (admin only)
     */
    public QuizSettings updateQuizSettings(QuizSettings settings) {
        // Deactivate all existing settings
        List<QuizSettings> allSettings = quizSettingsRepository.findAll();
        allSettings.forEach(s -> s.setIsActive(false));
        quizSettingsRepository.saveAll(allSettings);
        
        // Save new active settings
        settings.setIsActive(true);
        return quizSettingsRepository.save(settings);
    }
    
    /**
     * Simple Question record for quiz logic
     */
    public record Question(int operand1, int operand2, String operator, int correctAnswer) {
        public String getQuestionText() {
            return operand1 + " " + operator + " " + operand2 + " = ?";
        }
    }
}
