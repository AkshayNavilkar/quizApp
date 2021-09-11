package com.quiz.app.quiz.service;

import com.quiz.app.question.model.Question;
import com.quiz.app.quiz.model.Quiz;

import java.util.Optional;

public interface QuizService {

    Iterable<Quiz> getQuiz();

    Quiz addQuiz(Quiz quiz);

    Quiz updateQuiz(Quiz quiz, Integer quiz_id);

    Optional<Quiz> findQuiz(Integer quiz_id);
}
