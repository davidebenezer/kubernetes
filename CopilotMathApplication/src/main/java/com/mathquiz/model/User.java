package com.mathquiz.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * User entity representing both students and administrators
 */
@Entity
@Table(name = "users")
public class User implements UserDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    @Column(unique = true)
    private String username;
    
    @NotBlank(message = "Password is required")
    @Size(min = 4, message = "Password must be at least 4 characters")
    private String password;
    
    @NotBlank(message = "Full name is required")
    @Size(max = 100, message = "Full name must not exceed 100 characters")
    private String fullName;
    
    @Min(value = 5, message = "Age must be at least 5")
    @Max(value = 18, message = "Age must not exceed 18")
    private Integer age;
    
    @Min(value = 1, message = "Grade must be at least 1")
    @Max(value = 12, message = "Grade must not exceed 12")
    private Integer grade;
    
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;
    
    private boolean enabled = true;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<QuizSession> quizSessions;
    
    // Constructors
    public User() {}
    
    public User(String username, String password, String fullName, Integer age, Integer grade) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.age = age;
        this.grade = grade;
    }
    
    // UserDetails implementation
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }
    
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    
    @Override
    public boolean isEnabled() {
        return enabled;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    
    public Integer getGrade() { return grade; }
    public void setGrade(Integer grade) { this.grade = grade; }
    
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
    
    public void setEnabled(boolean enabled) { this.enabled = enabled; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public List<QuizSession> getQuizSessions() { return quizSessions; }
    public void setQuizSessions(List<QuizSession> quizSessions) { this.quizSessions = quizSessions; }
    
    public enum Role {
        USER, ADMIN
    }
}
