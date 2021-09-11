package com.quiz.app.assessment.model;

import org.json.JSONObject;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
public class Result
{
    @Id
    private Integer user_id;
    private String username;
    private String quiz_name;
    private String question;
    private String answer;
    private Boolean is_correct;

    public Integer getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getQuiz_name() {
        return quiz_name;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public Boolean getIs_correct() {
        return is_correct;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setQuiz_name(String quiz_name) {
        this.quiz_name = quiz_name;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setIs_correct(Boolean is_correct) {
        this.is_correct = is_correct;
    }
}
