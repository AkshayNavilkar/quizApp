package com.quiz.app.quiz.model;

import javax.persistence.*;

@Entity
@Table(name = "quiz")
public class Quiz
{
    @Id
    @Column(name = "quiz_id")
    private Integer quiz_id;

    @Column(name = "quiz_name")
    private String quiz_name;

    public Integer getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(Integer quiz_id) {
        if(quiz_id == null)
            System.out.println("Id cannot be null");
        else
            this.quiz_id = quiz_id;
    }

    public String getQuiz_name() {
        return quiz_name;
    }

    public void setQuiz_name(String quiz_name) {
        if(quiz_name.equals(""))
            System.out.println("Quiz name cannot be empty");
        else
            this.quiz_name = quiz_name;
    }
}
