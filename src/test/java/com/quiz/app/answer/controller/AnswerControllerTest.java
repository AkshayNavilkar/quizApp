package com.quiz.app.answer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quiz.app.answer.model.Answer;
import com.quiz.app.answer.repository.AnswerRepository;
import com.quiz.app.answer.service.AnswerService;
import com.quiz.app.question.repository.QuestionRepository;
import com.quiz.app.user.model.User;
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
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AnswerController.class)
public class AnswerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AnswerService answerService;

    @MockBean
    private AnswerRepository answerRepository;

    @MockBean
    private QuestionRepository questionRepository;

    private String mapToJson(Object object) throws JsonProcessingException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

    @Test
    public void getAnswers() throws Exception {
        Answer answer = new Answer();
        answer.setAnswer("B");
        answer.setAnswer_id(1);
        answer.setIs_correct(true);
        answer.setQuestion_id(1);

        Answer answer1 = new Answer();
        answer.setAnswer("A");
        answer.setAnswer_id(1);
        answer.setIs_correct(true);
        answer.setQuestion_id(2);

        List<Answer> answers = new ArrayList<>();
        answers.add(answer);
        answers.add(answer1);

        Mockito.when(answerService.getAnswer()).thenReturn(answers);

        String url = "http://localhost:8080/api/answers";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        String expectedJson = this.mapToJson(answers);
        String outputToJson = mvcResult.getResponse().getContentAsString();
        assertNotSame(outputToJson, expectedJson);
    }

    @Test
    public void insertAnswerTest() throws Exception {
        Answer answer = new Answer();
        answer.setAnswer("A");
        answer.setAnswer_id(1);
        answer.setIs_correct(true);
        answer.setQuestion_id(1);
        String inputToJson = this.mapToJson(answer);
        Mockito.when(answerService.insertAnswer(Mockito.any(Answer.class))).thenReturn(answer);
        String url = "http://localhost:8080/api/answer";
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
    public void updateAnswerTest() throws Exception {
        Answer answer = new Answer();
        answer.setAnswer("B");
        answer.setAnswer_id(1);
        answer.setIs_correct(true);
        answer.setQuestion_id(1);
        String inputToJson = this.mapToJson(answer);
        Mockito.when(answerService.updateAnswer(Mockito.any(Answer.class),Mockito.anyInt())).thenReturn(answer);
        String url = "http://localhost:8080/api/answer/update/1";
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
    public void findAnswerByQuestion_id() throws Exception {
        ArrayList<HashMap<String, Object>> al= new ArrayList<>();
        HashMap<String,Object> m= new HashMap<String,Object>();
        HashMap<String,Object> m1= new HashMap<String,Object>();
        HashMap<String,Object> m2= new HashMap<String,Object>();
        HashMap<String,Object> m3= new HashMap<String,Object>();
        m.put("question_id", 1);
        m.put("question", "abcd");
        m.put("answer_id", 1);
        m.put("answer","A");

        m1.put("question_id", 1);
        m1.put("question", "abcd");
        m1.put("answer_id", 1);
        m1.put("answer","B");

        m2.put("question_id", 1);
        m2.put("question", "abcd");
        m2.put("answer_id", 1);
        m2.put("answer","C");

        m3.put("question_id", 1);
        m3.put("question", "abcd");
        m3.put("answer_id", 1);
        m3.put("answer","D");

        al.add(m);
        al.add(m1);
        al.add(m2);
        al.add(m3);

        Mockito.when(answerService.findAnswerByQuestion_id(Mockito.anyInt())).thenReturn(al);
        String url = "http://localhost:8080/api/answer/find/1";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(url).accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        String expectedJson = this.mapToJson(al);
        String outputtoJson = mvcResult.getResponse().getContentAsString();
        assertNotSame(outputtoJson,expectedJson);
    }

    @Test
    public void viewAnswer() throws Exception {
        Answer answer = new Answer();
        answer.setAnswer("B");
        answer.setAnswer_id(1);
        answer.setIs_correct(true);
        answer.setQuestion_id(1);
        Mockito.when(answerService.viewAnswer(Mockito.anyInt())).thenReturn(java.util.Optional.of(answer));
        String url = "http://localhost:8080/api/answer/view/1";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(url).accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        String expectedJson = this.mapToJson(answer);
        String outputtoJson = mvcResult.getResponse().getContentAsString();
        assertNotSame(outputtoJson,expectedJson);
    }


}