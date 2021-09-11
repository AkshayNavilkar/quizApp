package com.quiz.app.user.service;

import com.quiz.app.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User addUser(User user);

    User updateUser(User user, Integer user_id);

    List<User> viewAllUsers();

    Optional<User> findUser(Integer user_id);

    boolean removeUser(Integer user_id);

}
