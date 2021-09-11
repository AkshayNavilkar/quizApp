package com.quiz.app.quiz.Impl;

import com.quiz.app.quiz.model.Quiz;
import com.quiz.app.quiz.repository.QuizRepository;
import com.quiz.app.user.Impl.UserServiceImpl;
import com.quiz.app.user.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuizServiceImplTest {

    @Autowired
    private QuizServiceImpl quizServiceImpl;

    @MockBean
    private QuizRepository quizRepository;

    @Test
    public void getQuiz()
    {
        Quiz quiz = new Quiz();
        quiz.setQuiz_id(1);
        quiz.setQuiz_name("Physics");

        Quiz quiz1 = new Quiz();
        quiz1.setQuiz_id(2);
        quiz1.setQuiz_name("Chemistry");

        List<Quiz> quizzes = new ArrayList<>();
        quizzes.add(quiz);
        quizzes.add(quiz1);

        Mockito.when(quizRepository.findAll()).thenReturn(quizzes);

        assertThat(quizServiceImpl.getQuiz()).isEqualTo(quizzes);
    }

    @Test
    public void addQuiz()
    {
        Quiz quiz = new Quiz();
        quiz.setQuiz_id(1);
        quiz.setQuiz_name("Physics");

        Mockito.when(quizRepository.save(quiz)).thenReturn(quiz);

        assertThat(quizServiceImpl.addQuiz(quiz)).isEqualTo(quiz);
    }

    @Test
    public void updateQuiz()
    {
        Quiz quiz = new Quiz();
        quiz.setQuiz_id(1);
        quiz.setQuiz_name("Physics");

        Mockito.when(quizRepository.save(quiz)).thenReturn(quiz);
        quiz.setQuiz_name("History");

        Mockito.when(quizRepository.save(quiz)).thenReturn(quiz);
        assertThat(quizServiceImpl.updateQuiz(quiz,1)).isEqualTo(quiz);
    }

    @Test
    public void findQuiz()
    {
        Quiz quiz = new Quiz();
        quiz.setQuiz_id(1);
        quiz.setQuiz_name("History");

        Mockito.when(quizRepository.findById(1)).thenReturn(java.util.Optional.of(quiz));
        assertThat(quizServiceImpl.findQuiz(1)).isEqualTo(java.util.Optional.of(quiz));
    }
}