package com.quiz.app.user.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User
{
    @Id
    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;



    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        if(user_id == null)
            System.out.println("Id cannot be empty");
        else
            this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if(username.equals(""))
            System.out.println("User name cannot be empty");
        else
            this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email.equals(""))
            System.out.println("Email cannot be empty");
        else
            this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password.equals(""))
            System.out.println("Password cannot be empty");
        else
            this.password = password;
    }
}
