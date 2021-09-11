package com.quiz.app.quiz.Impl;

import com.quiz.app.quiz.model.Quiz;
import com.quiz.app.quiz.repository.QuizRepository;
import com.quiz.app.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService
{
    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Iterable<Quiz> getQuiz()
    {
        return quizRepository.findAll();
    }

    @Override
    public Quiz addQuiz(Quiz quiz)
    {
        quiz.setQuiz_id(quiz.getQuiz_id());
        quiz.setQuiz_name(quiz.getQuiz_name());
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz, Integer quiz_id) {
        quiz.setQuiz_id(quiz_id);
        quiz.setQuiz_name(quiz.getQuiz_name());
        return quizRepository.save(quiz);
    }

    @Override
    public Optional<Quiz> findQuiz(Integer quiz_id) {
        return quizRepository.findById(quiz_id);
    }
}
