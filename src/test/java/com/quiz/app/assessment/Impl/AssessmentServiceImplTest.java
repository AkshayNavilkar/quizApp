package com.quiz.app.assessment.Impl;

import com.quiz.app.assessment.model.Assessment;
import com.quiz.app.assessment.repository.AssessmentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
public class AssessmentServiceImplTest {

    @Autowired
    private AssessmentServiceImpl assessmentServiceImpl;

    @MockBean
    private AssessmentRepository assessmentRepository;

    @Test
    public void getAssessment()
    {
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

        Mockito.when(assessmentRepository.findAll()).thenReturn(assessments);
        assertThat(assessmentServiceImpl.getAssessment()).isEqualTo(assessments);
    }

    @Test
    public void addAssessment() {
        Assessment assessment = new Assessment();
        assessment.setId(1);
        assessment.setUser_id(1);
        assessment.setAnswer_id(1);

        Mockito.when(assessmentRepository.save(assessment)).thenReturn(assessment);
        assertThat(assessmentServiceImpl.addAssessment(assessment)).isEqualTo(assessment);
    }

    @Test
    public void findAssessment() {
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
        ArrayList<String> str = new ArrayList<>();
        for(HashMap<String, Object> item : al)
            str.add(item.toString());
        Mockito.when(assessmentRepository.findAssessmentDetails(1,1)).thenReturn(str);
    }

    @Test
    public void findAllQuizResultsOfUser() {
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

        ArrayList<String> str = new ArrayList<>();
        for(HashMap<String, Object> item : al)
            str.add(item.toString());

        Mockito.when(assessmentRepository.findAllQuizResultsOfUser(1)).thenReturn(str);
    }
}