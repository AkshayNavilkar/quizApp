package com.quiz.app.question.controller;

import com.quiz.app.question.model.Question;
import com.quiz.app.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class QuestionController
{
    @Autowired
    QuestionService questionservice;

    @GetMapping("questions")
    public Iterable<Question> getQuestion()
    {
        return questionservice.getQuestion();
    }

    @PostMapping("question")
    public @ResponseBody Question addQuestion(@RequestBody Question question)
    {
        return questionservice.addQuestion(question);
    }

    @GetMapping("question/{question_id}")
    public @ResponseBody
    Optional<Question> findQuestion(@PathVariable Integer question_id)
    {
        return questionservice.findQuestion(question_id);
    }

    @GetMapping("questions/find/{quiz_id}")
    public @ResponseBody Iterable<Question> findQuestionsByQuiz_id(@PathVariable Integer quiz_id)
    {
        return questionservice.findQuestionsByQuiz_id(quiz_id);
    }
}
