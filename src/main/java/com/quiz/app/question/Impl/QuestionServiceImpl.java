package com.quiz.app.question.Impl;

import com.quiz.app.question.model.Question;
import com.quiz.app.question.repository.QuestionRepository;
import com.quiz.app.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Iterable<Question> getQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public Question addQuestion(Question question)
    {
        question.setQuestion_id(question.getQuestion_id());
        question.setQuestion(question.getQuestion());
        return questionRepository.save(question);
    }

    @Override
    public Optional<Question> findQuestion(Integer question_id) {
        return questionRepository.findById(question_id);
    }

    @Override
    public List<Question> findQuestionsByQuiz_id(Integer quiz_id) {
        return questionRepository.findQuestionByQuiz_id(quiz_id);
    }

    @Override
    public boolean removeQuestion(Integer question_id) {
        return false;
    }
}
