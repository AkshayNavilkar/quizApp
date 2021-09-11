package com.quiz.app.user.controller;

import com.quiz.app.user.model.User;
import com.quiz.app.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("user")
    public @ResponseBody User createUser(@RequestBody User user)
    {
        ServletUriComponentsBuilder.fromCurrentRequest();
        System.out.println(ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString());
        return userService.addUser(user);
    }

    @PutMapping("user/update/{user_id}")
    public @ResponseBody User updateUser(@RequestBody User user, @PathVariable Integer user_id)
    {
        ServletUriComponentsBuilder.fromCurrentRequest();
        System.out.println(ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString());
        return userService.updateUser(user,user_id);
    }

    @GetMapping("user/find/{user_id}")
    public @ResponseBody
    Optional<User> findUser(@PathVariable Integer user_id)
    {
        return userService.findUser(user_id);
    }

    @GetMapping("users")
    public @ResponseBody
    List<User> getUsers()
    {
        return userService.viewAllUsers();
    }
}
