package com.quiz.app.user.Impl;

import com.quiz.app.user.model.User;
import com.quiz.app.user.repository.UserRepository;
import com.quiz.app.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void addUser() {
        User user = new User();
        user.setUser_id(1);
        user.setUsername("Aks");
        user.setEmail("aks@g.com");
        user.setPassword("1223");

        Mockito.when(userRepository.save(user)).thenReturn(user);

        assertThat(userServiceImpl.addUser(user)).isEqualTo(user);
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setUser_id(1);
        user.setUsername("Aks");
        user.setEmail("aks@g.com");
        user.setPassword("1223");
        Mockito.when(userRepository.save(user)).thenReturn(user);

        user.setUsername("Aksh");
        Mockito.when(userRepository.save(user)).thenReturn(user);

        assertThat(userServiceImpl.updateUser(user,1)).isEqualTo(user);
    }

    @Test
    public void viewAllUsers() {
        User user = new User();
        user.setUser_id(1);
        user.setUsername("Aks");
        user.setEmail("aks@g.com");
        user.setPassword("abc");

        User user1 = new User();
        user.setUser_id(2);
        user.setUsername("Aksay");
        user.setEmail("aksay@g.com");
        user.setPassword("1223");

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);

        Mockito.when(userRepository.findAll()).thenReturn(users);

        assertThat(userServiceImpl.viewAllUsers()).isEqualTo(users);
    }

    @Test
    public void findUser() {
        User user = new User();
        user.setUser_id(1);
        user.setUsername("Aks");
        user.setEmail("aks@g.com");
        user.setPassword("abc");

        Mockito.when(userRepository.findById(1)).thenReturn(java.util.Optional.of(user));

        assertThat(userServiceImpl.findUser(1)).isEqualTo(java.util.Optional.of(user));
    }
}