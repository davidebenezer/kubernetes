package com.mathquiz.repository;

import com.mathquiz.model.QuizSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Repository interface for QuizSettings entity
 */
@Repository
public interface QuizSettingsRepository extends JpaRepository<QuizSettings, Long> {
    
    /**
     * Find active quiz settings
     */
    Optional<QuizSettings> findByIsActiveTrue();
}
