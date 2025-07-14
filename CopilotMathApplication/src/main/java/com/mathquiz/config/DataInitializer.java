package com.mathquiz.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import main.java.com.mathquiz.model.QuizSettings;
import main.java.com.mathquiz.model.User;
import main.java.com.mathquiz.repository.QuizSettingsRepository;
import main.java.com.mathquiz.repository.UserRepository;

/**
 * Data initialization for default admin user and settings
 */
@Component
public class DataInitializer implements CommandLineRunner {
    
    private final UserRepository userRepository;
    private final QuizSettingsRepository quizSettingsRepository;
    private final PasswordEncoder passwordEncoder;
    
    public DataInitializer(UserRepository userRepository, 
                          QuizSettingsRepository quizSettingsRepository,
                          PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.quizSettingsRepository = quizSettingsRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    @Override
    public void run(String... args) throws Exception {
        // Create default admin user if not exists
        if (!userRepository.existsByUsername("admin")) {
            User admin = new User("admin", passwordEncoder.encode("admin"), "Administrator", 18, 12);
            admin.setRole(User.Role.ADMIN);
            userRepository.save(admin);
            System.out.println("Default admin user created: admin/admin");
        }
        
        // Create default quiz settings if not exists
        if (quizSettingsRepository.findByIsActiveTrue().isEmpty()) {
            QuizSettings defaultSettings = new QuizSettings();
            quizSettingsRepository.save(defaultSettings);
            System.out.println("Default quiz settings created");
        }
    }
}
