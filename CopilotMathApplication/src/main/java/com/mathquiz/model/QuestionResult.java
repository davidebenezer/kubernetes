package com.mathquiz.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Question result entity representing an individual question answer
 */
@Entity
@Table(name = "question_results")
public class QuestionResult {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_session_id")
    private QuizSession quizSession;
    
    @Column(name = "question_text")
    private String questionText;
    
    @Column(name = "correct_answer")
    private Integer correctAnswer;
    
    @Column(name = "user_answer")
    private Integer userAnswer;
    
    @Column(name = "is_correct")
    private Boolean isCorrect;
    
    @Column(name = "time_taken_seconds")
    private Long timeTakenSeconds;
    
    @Column(name = "is_timed_out")
    private Boolean isTimedOut = false;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    
    // Constructors
    public QuestionResult() {}
    
    public QuestionResult(QuizSession quizSession, String questionText, Integer correctAnswer) {
        this.quizSession = quizSession;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public QuizSession getQuizSession() { return quizSession; }
    public void setQuizSession(QuizSession quizSession) { this.quizSession = quizSession; }
    
    public String getQuestionText() { return questionText; }
    public void setQuestionText(String questionText) { this.questionText = questionText; }
    
    public Integer getCorrectAnswer() { return correctAnswer; }
    public void setCorrectAnswer(Integer correctAnswer) { this.correctAnswer = correctAnswer; }
    
    public Integer getUserAnswer() { return userAnswer; }
    public void setUserAnswer(Integer userAnswer) { this.userAnswer = userAnswer; }
    
    public Boolean getIsCorrect() { return isCorrect; }
    public void setIsCorrect(Boolean isCorrect) { this.isCorrect = isCorrect; }
    
    public Long getTimeTakenSeconds() { return timeTakenSeconds; }
    public void setTimeTakenSeconds(Long timeTakenSeconds) { this.timeTakenSeconds = timeTakenSeconds; }
    
    public Boolean getIsTimedOut() { return isTimedOut; }
    public void setIsTimedOut(Boolean isTimedOut) { this.isTimedOut = isTimedOut; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
