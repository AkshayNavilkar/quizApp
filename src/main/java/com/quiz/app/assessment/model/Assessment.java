package com.quiz.app.assessment.model;

import com.quiz.app.answer.model.Answer;
import com.quiz.app.quiz.model.Quiz;
import com.quiz.app.user.model.User;

import javax.persistence.*;

@Entity
public class Assessment {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "answer_id")
    private Integer answer_id;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne(targetEntity = Answer.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "answer_id", referencedColumnName = "answer_id", insertable = false, updatable = false)
    private Answer answer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if(id == null)
            System.out.println("Id cannot be null");
        else
            this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        if(user_id == null)
            System.out.println("Id cannot be null");
        else
            this.user_id = user_id;
    }

    public Integer getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(Integer answer_id) {
        if(answer_id == null)
            System.out.println("Id cannot be null");
        else
            this.answer_id = answer_id;
    }
}
