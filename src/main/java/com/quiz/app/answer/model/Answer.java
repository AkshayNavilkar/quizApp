package com.quiz.app.answer.model;

import com.quiz.app.assessment.model.Assessment;
import com.quiz.app.question.model.Question;

import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer
{
	@Id
	@Column(name = "answer_id", unique = true, nullable = false)
	private Integer answer_id;
	
	@Column(name = "answer")
	private String answer;
	
	@Column(name = "question_id")
	private Integer question_id;
	
	@Column(name = "is_correct")
	private boolean is_correct;

	@ManyToOne(targetEntity = Question.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "question_id", referencedColumnName = "question_id", insertable = false, updatable = false)
	private Question question;


	public Integer getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(Integer question_id) {
		this.question_id = question_id;
	}

	public Integer getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(Integer answer_id) {
		if(answer_id == null)
			System.out.println("Answer id cannot be null");
		else
			this.answer_id = answer_id;
	}
	
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		if(answer.equals(""))
			System.out.println("Answer cannot be empty.");
		else
			this.answer = answer;
	}

	
	public boolean isIs_correct() {
		return is_correct;
	}
	public void setIs_correct(boolean is_correct) {
		this.is_correct = is_correct;
	}
}
