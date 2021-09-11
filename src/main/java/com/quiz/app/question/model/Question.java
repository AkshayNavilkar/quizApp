package com.quiz.app.question.model;

import com.quiz.app.answer.model.Answer;
import com.quiz.app.quiz.model.Quiz;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
public class Question{

    @Id
    @Column(name = "question_id")
    private Integer question_id;

    @Column(name = "question")
    private String question;

    @Column(name = "quiz_id")
    private Integer quiz_id;

    @ManyToOne(targetEntity = Quiz.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "quiz_id", referencedColumnName = "quiz_id", insertable = false, updatable = false)
    private Quiz quiz;

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        if(question_id == null)
            System.out.println("Id cannot be null");
        else
            this.question_id = question_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        if(question.equals(""))
            System.out.println("Question cannot be empty");
        else
            this.question = question;
    }

    public Integer getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(Integer quiz_id) {
        if(quiz_id == null)
            System.out.println("id cannot be null");
        else
            this.quiz_id = quiz_id;
    }
}
