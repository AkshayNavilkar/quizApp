package com.quiz.app.quiz.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quiz.app.answer.controller.AnswerController;
import com.quiz.app.answer.model.Answer;
import com.quiz.app.answer.repository.AnswerRepository;
import com.quiz.app.answer.service.AnswerService;
import com.quiz.app.question.repository.QuestionRepository;
import com.quiz.app.quiz.model.Quiz;
import com.quiz.app.quiz.repository.QuizRepository;
import com.quiz.app.quiz.service.QuizService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@WebMvcTest(value = QuizController.class)
public class QuizControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuizService quizService;

    @MockBean
    private QuizRepository quizRepository;

    private String mapToJson(Object object) throws JsonProcessingException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

    @Test
    public void getQuiz() throws Exception {
        Quiz quiz = new Quiz();
        quiz.setQuiz_id(1);
        quiz.setQuiz_name("Physics");

        Quiz quiz1 = new Quiz();
        quiz1.setQuiz_id(2);
        quiz1.setQuiz_name("Chemistry");

        List<Quiz> quizzes = new ArrayList<>();
        quizzes.add(quiz);
        quizzes.add(quiz1);

        Mockito.when(quizService.getQuiz()).thenReturn(quizzes);

        String url = "http://localhost:8080/api/quizzes";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        String expectedJson = this.mapToJson(quizzes);
        String outputToJson = mvcResult.getResponse().getContentAsString();
        assertNotSame(outputToJson, expectedJson);
    }

    @Test
    public void createQuiz() throws Exception {
        Quiz quiz = new Quiz();
        quiz.setQuiz_id(1);
        quiz.setQuiz_name("Physics");
        String inputToJson = this.mapToJson(quiz);
        Mockito.when(quizService.addQuiz(Mockito.any(Quiz.class))).thenReturn(quiz);
        String url = "http://localhost:8080/api/quiz";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(url).accept(MediaType.APPLICATION_JSON).content(inputToJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        String outputToJson = response.getContentAsString();
        assertNotSame(outputToJson,inputToJson);
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void updateQuiz() throws Exception {
        Quiz quiz = new Quiz();
        quiz.setQuiz_id(1);
        quiz.setQuiz_name("History");
        String inputToJson = this.mapToJson(quiz);
        Mockito.when(quizService.updateQuiz(Mockito.any(Quiz.class),Mockito.anyInt())).thenReturn(quiz);
        String url = "http://localhost:8080/api/quiz/update/1";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put(url).accept(MediaType.APPLICATION_JSON).content(inputToJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        String outputToJson = response.getContentAsString();
        assertNotSame(outputToJson,inputToJson);
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void findQuiz() throws Exception {
        Quiz quiz = new Quiz();
        quiz.setQuiz_id(1);
        quiz.setQuiz_name("History");
        Mockito.when(quizService.findQuiz(Mockito.anyInt())).thenReturn(java.util.Optional.of(quiz));
        String url = "http://localhost:8080/api/quiz/1";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(url).accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        String expectedJson = this.mapToJson(quiz);
        String outputtoJson = mvcResult.getResponse().getContentAsString();
        assertNotSame(outputtoJson,expectedJson);
    }
}