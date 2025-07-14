package com.mathquiz.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.mathquiz.model.User;
import main.java.com.mathquiz.repository.UserRepository;

/**
 * Service for user management and authentication
 */
@Service
@Transactional
public class UserService implements UserDetailsService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }
    
    /**
     * Register a new user
     */
    public User registerUser(String username, String password, String fullName, Integer age, Integer grade) {
        if (userRepository.existsByUsername(username)) {
            throw new RuntimeException("Username already exists");
        }
        
        User user = new User(username, passwordEncoder.encode(password), fullName, age, grade);
        return userRepository.save(user);
    }
    
    /**
     * Find user by username
     */
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
    
    /**
     * Get all users (for admin)
     */
    public java.util.List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    /**
     * Check if username is available
     */
    public boolean isUsernameAvailable(String username) {
        return !userRepository.existsByUsername(username);
    }
}
