package com.quiz.app.answer.controller;

import com.quiz.app.answer.repository.AnswerRepository;
import com.quiz.app.answer.service.Bundle;
import com.quiz.app.question.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.quiz.app.answer.model.Answer;
import com.quiz.app.answer.service.AnswerService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AnswerController 
{
	@Autowired
	private AnswerService answerService;

	@Autowired
	private AnswerRepository answerRepository;

	@Autowired
	private QuestionRepository questionRepository;
	
	@GetMapping("answers")
	public Iterable<Answer> getAnswers()
	{
		return answerService.getAnswer();
	}

	@PostMapping("answer")
    public @ResponseBody Answer insertAnswer(@RequestBody Answer answer)
    {
        return answerService.insertAnswer(answer);
    }

	@PutMapping("answer/update/{answer_id}")
	public @ResponseBody Answer updateAnswer(@RequestBody Answer answer, @PathVariable Integer answer_id)
	{
		return answerService.updateAnswer(answer, answer_id);
	}

    @GetMapping("answer/find/{question_id}")
	public ArrayList<HashMap<String, Object>> findAnswerByQuestion_id(@PathVariable Integer question_id)
	{
		return answerService.findAnswerByQuestion_id(question_id);
	}

	@GetMapping("answer/view/{answer_id}")
	public @ResponseBody Optional<Answer> viewAnswer(@PathVariable Integer answer_id)
	{
		return answerService.viewAnswer(answer_id);
	}

	@DeleteMapping("answer/delete/{answer_id}")
	public void deleteAnswer(@PathVariable Integer answer_id)
	{
		answerService.deleteAnswer(answer_id);
	}
}
