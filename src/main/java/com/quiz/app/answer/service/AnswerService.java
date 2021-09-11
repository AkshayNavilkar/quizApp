package com.quiz.app.answer.service;

import com.quiz.app.answer.model.Answer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;


public interface AnswerService
{
	Iterable<Answer> getAnswer();

	Answer insertAnswer(Answer answer);

	Answer updateAnswer(Answer answer, Integer answer_id);

	ArrayList<HashMap<String, Object>> findAnswerByQuestion_id(Integer question_id);

	Optional<Answer> viewAnswer(Integer answer_id);

	void deleteAnswer(Integer answer_id);
}
