package com.quiz.app.answer.Impl;

import com.quiz.app.answer.model.Answer;
import com.quiz.app.answer.service.Bundle;
import org.springframework.beans.factory.annotation.Autowired;

import com.quiz.app.answer.repository.AnswerRepository;
import com.quiz.app.answer.service.AnswerService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AnswerServiceImpl implements AnswerService
{
	@Autowired
	private AnswerRepository answerRepository;

	public Iterable<Answer> getAnswer() {
		return answerRepository.findAll();
	}

	@Override
    public Answer insertAnswer(Answer answer)
	{
		answer.setAnswer_id(answer.getAnswer_id());
		answer.setAnswer(answer.getAnswer());
		answer.setQuestion_id(answer.getQuestion_id());
		answer.setIs_correct(answer.isIs_correct());
		return answerRepository.save(answer);
    }

	@Override
	public Answer updateAnswer(Answer answer, Integer answer_id)
	{
		answer.setAnswer_id(answer_id);
		answer.setAnswer(answer.getAnswer());
		answer.setQuestion_id(answer.getQuestion_id());
		answer.setIs_correct(answer.isIs_correct());
		return answerRepository.save(answer);
	}


	public ArrayList<HashMap<String, Object>> findAnswerByQuestion_id(Integer question_id)
	{
		ArrayList<HashMap<String, Object>> al= new ArrayList<>();
		ArrayList<String> bl= new ArrayList<>();
		bl.addAll(answerRepository.findAnswerByQuestion_id(question_id));
		HashMap<String,Object> m= new HashMap<String,Object>();
		String[] res;
		for(int i=0;i<bl.size();i++)
		{
			res = bl.get(i).split(",");
			m.put("question_id", new Integer(res[0]));
			m.put("question", res[1]);
			m.put("answer_id",res[2]);
			m.put("answer",res[3]);
			al.add(new HashMap<String,Object>(m));
		}
		return al;
	}


	public Optional<Answer> viewAnswer(Integer answer_id)
	{
		return answerRepository.findById(answer_id);
	}

	public void deleteAnswer(Integer answer_id)
	{
		answerRepository.deleteById(answer_id);
	}
}
