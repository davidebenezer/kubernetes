package com.mathquiz.model;

import jakarta.persistence.*;

/**
 * Quiz settings entity for admin customization
 */
@Entity
@Table(name = "quiz_settings")
public class QuizSettings {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "timeout_seconds")
    private Integer timeoutSeconds = 20;
    
    @Column(name = "max_breaks")
    private Integer maxBreaks = 2;
    
    @Column(name = "break_duration_minutes")
    private Integer breakDurationMinutes = 5;
    
    @Column(name = "questions_per_session")
    private Integer questionsPerSession = 100;
    
    @Column(name = "allow_addition")
    private Boolean allowAddition = true;
    
    @Column(name = "allow_subtraction")
    private Boolean allowSubtraction = true;
    
    @Column(name = "allow_multiplication")
    private Boolean allowMultiplication = true;
    
    @Column(name = "allow_division")
    private Boolean allowDivision = true;
    
    @Column(name = "min_number")
    private Integer minNumber = 1;
    
    @Column(name = "max_number")
    private Integer maxNumber = 10;
    
    @Column(name = "is_active")
    private Boolean isActive = true;
    
    // Constructors
    public QuizSettings() {}
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Integer getTimeoutSeconds() { return timeoutSeconds; }
    public void setTimeoutSeconds(Integer timeoutSeconds) { this.timeoutSeconds = timeoutSeconds; }
    
    public Integer getMaxBreaks() { return maxBreaks; }
    public void setMaxBreaks(Integer maxBreaks) { this.maxBreaks = maxBreaks; }
    
    public Integer getBreakDurationMinutes() { return breakDurationMinutes; }
    public void setBreakDurationMinutes(Integer breakDurationMinutes) { this.breakDurationMinutes = breakDurationMinutes; }
    
    public Integer getQuestionsPerSession() { return questionsPerSession; }
    public void setQuestionsPerSession(Integer questionsPerSession) { this.questionsPerSession = questionsPerSession; }
    
    public Boolean getAllowAddition() { return allowAddition; }
    public void setAllowAddition(Boolean allowAddition) { this.allowAddition = allowAddition; }
    
    public Boolean getAllowSubtraction() { return allowSubtraction; }
    public void setAllowSubtraction(Boolean allowSubtraction) { this.allowSubtraction = allowSubtraction; }
    
    public Boolean getAllowMultiplication() { return allowMultiplication; }
    public void setAllowMultiplication(Boolean allowMultiplication) { this.allowMultiplication = allowMultiplication; }
    
    public Boolean getAllowDivision() { return allowDivision; }
    public void setAllowDivision(Boolean allowDivision) { this.allowDivision = allowDivision; }
    
    public Integer getMinNumber() { return minNumber; }
    public void setMinNumber(Integer minNumber) { this.minNumber = minNumber; }
    
    public Integer getMaxNumber() { return maxNumber; }
    public void setMaxNumber(Integer maxNumber) { this.maxNumber = maxNumber; }
    
    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }
}
