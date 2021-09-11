package com.quiz.app.assessment.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quiz.app.assessment.model.Assessment;
import com.quiz.app.assessment.repository.AssessmentRepository;
import com.quiz.app.assessment.service.AssessmentService;
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
@WebMvcTest(value = AssessmentController.class)
public class AssessmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AssessmentService assessmentService;

    @MockBean
    private AssessmentRepository AssessmentRepository;

    private String mapToJson(Object object) throws JsonProcessingException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

    @Test
    public void getAssessmentTest() throws Exception {
        Assessment assessment = new Assessment();
        assessment.setId(1);
        assessment.setUser_id(1);
        assessment.setAnswer_id(1);

        Assessment assessment1 = new Assessment();
        assessment1.setId(2);
        assessment1.setUser_id(1);
        assessment1.setAnswer_id(3);

        List<Assessment> assessments = new ArrayList<>();
        assessments.add(assessment);
        assessments.add(assessment1);

        Mockito.when(assessmentService.getAssessment()).thenReturn(assessments);

        String url = "http://localhost:8080/api/assessments";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        String expectedJson = this.mapToJson(assessment);
        String outputToJson = mvcResult.getResponse().getContentAsString();
        assertNotSame(outputToJson, expectedJson);
    }

    @Test
    public void addAssessmentTest() throws Exception {
        Assessment assessment = new Assessment();
        assessment.setId(1);
        assessment.setUser_id(1);
        assessment.setAnswer_id(1);
        String inputToJson = this.mapToJson(assessment);
        Mockito.when(assessmentService.addAssessment(Mockito.any(Assessment.class))).thenReturn(assessment);
        String url = "http://localhost:8080/api/assessment";
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
    public void findAssessmentByUseridAndQuizidTest() throws Exception {
        ArrayList<HashMap<String, Object>> al= new ArrayList<>();
        HashMap<String,Object> m= new HashMap<String,Object>();
        HashMap<String,Object> m1= new HashMap<String,Object>();
        HashMap<String,Object> m2= new HashMap<String,Object>();
        HashMap<String,Object> m3= new HashMap<String,Object>();
        m.put("user_id", 1);
        m.put("username", "Aks");
        m.put("quiz_id",1);
        m.put("quiz_name","History");
        m.put("question","Who is God");
        m.put("answer","A");
        m.put("is_correct",true);

        m1.put("user_id", 1);
        m1.put("username", "Aks");
        m1.put("quiz_id",1);
        m1.put("quiz_name","History");
        m1.put("question","Who made us?");
        m1.put("answer","B");
        m1.put("is_correct",false);

        m2.put("user_id", 1);
        m2.put("username", "Aks");
        m2.put("quiz_id",1);
        m2.put("quiz_name","History");
        m2.put("question","Who are we");
        m2.put("answer","B");
        m2.put("is_correct",true);

        m3.put("user_id", 1);
        m3.put("username", "Aks");
        m3.put("quiz_id",1);
        m3.put("quiz_name","History");
        m3.put("question","Who made earth");
        m3.put("answer","A");
        m3.put("is_correct",true);

        al.add(m);
        al.add(m1);
        al.add(m2);
        al.add(m3);

        Mockito.when(assessmentService.findAssessment(Mockito.anyInt(),Mockito.anyInt())).thenReturn(al);
        String url = "http://localhost:8080/api/assessment/find/1/1";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(url).accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        String expectedJson = this.mapToJson(al);
        String outputtoJson = mvcResult.getResponse().getContentAsString();
        assertNotSame(outputtoJson,expectedJson);
    }

    @Test
    public void findQuizResultByUseridTest() throws Exception {
        ArrayList<HashMap<String, Object>> al= new ArrayList<>();
        HashMap<String,Object> m= new HashMap<String,Object>();
        HashMap<String,Object> m1= new HashMap<String,Object>();
        HashMap<String,Object> m2= new HashMap<String,Object>();
        HashMap<String,Object> m3= new HashMap<String,Object>();
        m.put("user_id", 1);
        m.put("username", "Aks");
        m.put("quiz_name","History");
        m.put("question","Who is God");
        m.put("answer","A");
        m.put("is_correct",true);

        m1.put("user_id", 1);
        m1.put("username", "Aks");
        m1.put("quiz_name","History");
        m1.put("question","Who made us?");
        m1.put("answer","B");
        m1.put("is_correct",false);

        m2.put("user_id", 1);
        m2.put("username", "Aks");
        m2.put("quiz_name","History");
        m2.put("question","Who are we");
        m2.put("answer","B");
        m2.put("is_correct",true);

        m3.put("user_id", 1);
        m3.put("username", "Aks");
        m3.put("quiz_name","History");
        m3.put("question","Who made earth");
        m3.put("answer","A");
        m3.put("is_correct",true);

        al.add(m);
        al.add(m1);
        al.add(m2);
        al.add(m3);

        Mockito.when(assessmentService.findAllQuizResultsOfUser(Mockito.anyInt())).thenReturn(al);
        String url = "http://localhost:8080/api/assessment/find/result/1";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(url).accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        String expectedJson = this.mapToJson(al);
        String outputtoJson = mvcResult.getResponse().getContentAsString();
        assertNotSame(outputtoJson,expectedJson);
    }
}