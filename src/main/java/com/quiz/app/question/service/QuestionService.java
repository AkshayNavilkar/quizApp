package com.quiz.app.question.service;

import com.quiz.app.assessment.model.Assessment;
import com.quiz.app.question.model.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService{
    Iterable<Question> getQuestion();

    Question addQuestion(Question question);

    Optional<Question> findQuestion(Integer question_id);

    List<Question> findQuestionsByQuiz_id(Integer quiz_id);

    boolean removeQuestion(Integer question_id);
}
