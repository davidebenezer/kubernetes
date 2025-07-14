package com.mathquiz.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Quiz session entity representing a completed quiz session
 */
@Entity
@Table(name = "quiz_sessions")
public class QuizSession {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    @Column(name = "operation_type")
    private String operationType;
    
    @Column(name = "total_questions")
    private Integer totalQuestions;
    
    @Column(name = "correct_answers")
    private Integer correctAnswers;
    
    @Column(name = "total_time_seconds")
    private Long totalTimeSeconds;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @OneToMany(mappedBy = "quizSession", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<QuestionResult> questionResults;
    
    // Constructors
    public QuizSession() {}
    
    public QuizSession(User user, String operationType) {
        this.user = user;
        this.operationType = operationType;
        this.totalQuestions = 0;
        this.correctAnswers = 0;
        this.totalTimeSeconds = 0L;
    }
    
    // Calculated fields
    public double getAccuracy() {
        if (totalQuestions == null || totalQuestions == 0) {
            return 0.0;
        }
        return (double) correctAnswers / totalQuestions * 100.0;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    
    public String getOperationType() { return operationType; }
    public void setOperationType(String operationType) { this.operationType = operationType; }
    
    public Integer getTotalQuestions() { return totalQuestions; }
    public void setTotalQuestions(Integer totalQuestions) { this.totalQuestions = totalQuestions; }
    
    public Integer getCorrectAnswers() { return correctAnswers; }
    public void setCorrectAnswers(Integer correctAnswers) { this.correctAnswers = correctAnswers; }
    
    public Long getTotalTimeSeconds() { return totalTimeSeconds; }
    public void setTotalTimeSeconds(Long totalTimeSeconds) { this.totalTimeSeconds = totalTimeSeconds; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public List<QuestionResult> getQuestionResults() { return questionResults; }
    public void setQuestionResults(List<QuestionResult> questionResults) { this.questionResults = questionResults; }
}
