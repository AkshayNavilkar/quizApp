package com.quiz.app.user.Impl;

import com.quiz.app.user.model.User;
import com.quiz.app.user.repository.UserRepository;
import com.quiz.app.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user)
    {
        user.setUser_id(user.getUser_id());
        user.setUsername(user.getUsername());
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user, Integer user_id) {
        user.setUser_id(user_id);
        user.setUsername(user.getUsername());
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        return userRepository.save(user);
    }

    @Override
    public List<User> viewAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUser(Integer user_id) {
        return userRepository.findById(user_id);
    }

    @Override
    public boolean removeUser(Integer user_id) {
        return false;
    }

}
