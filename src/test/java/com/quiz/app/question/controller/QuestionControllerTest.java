package com.quiz.app.question.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quiz.app.question.model.Question;
import com.quiz.app.question.repository.QuestionRepository;
import com.quiz.app.question.service.QuestionService;
import com.quiz.app.user.controller.UserController;
import com.quiz.app.user.model.User;
import com.quiz.app.user.repository.UserRepository;
import com.quiz.app.user.service.UserService;
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
@WebMvcTest(value = QuestionController.class)
public class QuestionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestionService questionService;

    @MockBean
    private QuestionRepository questionRepository;

    private String mapToJson(Object object) throws JsonProcessingException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

    @Test
    public void getQuestionTest() throws Exception {
        Question question = new Question();
        question.setQuestion_id(1);
        question.setQuestion("Who is God");
        question.setQuiz_id(1);

        Question question1 = new Question();
        question.setQuestion_id(2);
        question.setQuestion("Who made you?");
        question.setQuiz_id(1);

        List<Question> questions = new ArrayList<>();
        questions.add(question);
        questions.add(question1);

        Mockito.when(questionService.getQuestion()).thenReturn(questions);

        String url = "http://localhost:8080/api/questions";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        String expectedJson = this.mapToJson(questions);
        String outputToJson = mvcResult.getResponse().getContentAsString();
        assertNotSame(outputToJson, expectedJson);
    }

    @Test
    public void addQuestionTest() throws Exception {
        Question question = new Question();
        question.setQuestion_id(1);
        question.setQuestion("Who is God");
        question.setQuiz_id(1);
        String inputToJson = this.mapToJson(question);
        Mockito.when(questionService.addQuestion(Mockito.any(Question.class))).thenReturn(question);
        String url = "http://localhost:8080/api/question";
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
    public void findQuestionTest() throws Exception {
        Question question = new Question();
        question.setQuestion_id(1);
        question.setQuestion("Who is God");
        question.setQuiz_id(1);
        Mockito.when(questionService.findQuestion(Mockito.anyInt())).thenReturn(java.util.Optional.of(question));
        String url = "http://localhost:8080/api/question/1";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(url).accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        String expectedJson = this.mapToJson(question);
        String outputtoJson = mvcResult.getResponse().getContentAsString();
        assertNotSame(outputtoJson,expectedJson);
    }

    @Test
    public void findQuestionsByQuiz_idTest() throws Exception {
        Question question = new Question();
        question.setQuestion_id(1);
        question.setQuestion("Who is God");
        question.setQuiz_id(1);

        Question question1 = new Question();
        question.setQuestion_id(2);
        question.setQuestion("Who made you?");
        question.setQuiz_id(1);

        List<Question> questions = new ArrayList<>();
        questions.add(question);
        questions.add(question1);

        Mockito.when(questionService.getQuestion()).thenReturn(questions);

        String url = "http://localhost:8080/api/questions/find/1";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        String expectedJson = this.mapToJson(questions);
        String outputToJson = mvcResult.getResponse().getContentAsString();
        assertNotSame(outputToJson, expectedJson);
    }
}