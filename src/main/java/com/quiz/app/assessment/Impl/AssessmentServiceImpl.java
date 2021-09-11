package com.quiz.app.assessment.Impl;


import com.quiz.app.answer.service.Bundle;
import com.quiz.app.assessment.model.Assessment;
import com.quiz.app.assessment.model.Result;
import com.quiz.app.assessment.repository.AssessmentRepository;
import com.quiz.app.assessment.service.AssessmentService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class AssessmentServiceImpl implements AssessmentService
{
    @Autowired
    private AssessmentRepository assessmentRepository;

    @Override
    public Iterable<Assessment> getAssessment() {
        return assessmentRepository.findAll();
    }

    @Override
    public Assessment addAssessment(Assessment assessment)
    {
        assessment.setAnswer_id(assessment.getAnswer_id());
        assessment.setId(assessment.getId());
        assessment.setUser_id(assessment.getUser_id());
        return assessmentRepository.save(assessment);
    }

    @Override
    public ArrayList<HashMap<String, Object>> findAssessment(Integer user_id, Integer quiz_id)
    {
        ArrayList<HashMap<String, Object>> al= new ArrayList<>();
        ArrayList<String> bl= new ArrayList<>();
        bl.addAll(assessmentRepository.findAssessmentDetails(user_id, quiz_id));
        HashMap<String,Object> m= new HashMap<String,Object>();
        String[] res;
        for(int i=0;i<bl.size();i++)
        {
            res = bl.get(i).split(",");
            m.put("user_id", new Integer(res[0]));
            m.put("username", res[1]);
            m.put("quiz_id",res[2]);
            m.put("quiz_name",res[3]);
            m.put("question",res[4]);
            m.put("answer",res[5]);
            m.put("is_correct",new Boolean(res[6]));
            al.add(new HashMap<String,Object>(m));
        }
        return al;
    }

    @Override
    public String countCorrect(Integer user_id) {
        return assessmentRepository.countCorrect(user_id);
    }

    @Override
    public String countWrong(Integer user_id) {
        return assessmentRepository.countWrong(user_id);
    }

    @Override
    public boolean removeAssessment(Integer id) {
        return false;
    }

    @Override
    public ArrayList<HashMap<String, Object>> findAllQuizResultsOfUser(Integer user_id)
    {
        ArrayList<HashMap<String, Object>> al= new ArrayList<>();
        ArrayList<String> bl= new ArrayList<>();
        bl.addAll(assessmentRepository.findAllQuizResultsOfUser(user_id));
        HashMap<String,Object> m= new HashMap<String,Object>();
        String[] res;
        for(int i=0;i<bl.size();i++)
        {
            res = bl.get(i).split(",");
            m.put("user_id", new Integer(res[0]));
            m.put("username", res[1]);
            m.put("quiz_name",res[2]);
            m.put("question",res[3]);
            m.put("answer",res[4]);
            m.put("is_correct",new Boolean(res[5]));
            al.add(new HashMap<String,Object>(m));
        }
        return al;
    }
}
