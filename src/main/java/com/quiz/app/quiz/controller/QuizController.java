package com.quiz.app.quiz.controller;

import com.quiz.app.quiz.model.Quiz;
import com.quiz.app.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class QuizController
{
    @Autowired
    private QuizService quizService;

    @GetMapping("quizzes")
    public @ResponseBody Iterable<Quiz> getQuiz()
    {
        return quizService.getQuiz();
    }


    @PostMapping("quiz")
    public @ResponseBody Quiz createQuiz(@RequestBody Quiz quiz)
    {
        return quizService.addQuiz(quiz);
    }

    @PutMapping("quiz/update/{quiz_id}")
    public @ResponseBody Quiz updateQuiz(@RequestBody Quiz quiz, @PathVariable Integer quiz_id)
    {
        return quizService.updateQuiz(quiz, quiz_id);
    }

    @GetMapping("quiz/{quiz_id}")
    public @ResponseBody
    Optional<Quiz> findQuiz(@PathVariable Integer quiz_id)
    {
        return quizService.findQuiz(quiz_id);
    }
}
