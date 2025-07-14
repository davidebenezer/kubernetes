package com.mathquiz.repository;

import com.mathquiz.model.QuizSession;
import com.mathquiz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository interface for QuizSession entity
 */
@Repository
public interface QuizSessionRepository extends JpaRepository<QuizSession, Long> {
    
    /**
     * Find all quiz sessions for a user
     */
    List<QuizSession> findByUserOrderByCreatedAtDesc(User user);
    
    /**
     * Find recent quiz sessions for a user
     */
    @Query("SELECT qs FROM QuizSession qs WHERE qs.user = :user ORDER BY qs.createdAt DESC")
    List<QuizSession> findRecentSessionsByUser(@Param("user") User user);
    
    /**
     * Count total sessions by user
     */
    long countByUser(User user);
}
