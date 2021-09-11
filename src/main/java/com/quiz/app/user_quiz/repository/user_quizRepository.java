package com.quiz.app.user_quiz.repository;

import com.quiz.app.user_quiz.model.User_quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface user_quizRepository extends JpaRepository<User_quiz, Integer> {
}
