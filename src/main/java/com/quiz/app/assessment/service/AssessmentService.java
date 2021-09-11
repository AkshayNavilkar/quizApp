package com.quiz.app.assessment.service;

import com.quiz.app.assessment.model.Assessment;
import com.quiz.app.assessment.model.Result;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

public interface AssessmentService {
    Iterable<Assessment> getAssessment();

    Assessment addAssessment(Assessment assessment);

    ArrayList<HashMap<String, Object>> findAssessment(Integer user_id, Integer quiz_id) throws JSONException;

    String countCorrect(Integer user_id);

    String countWrong(Integer user_id);

    boolean removeAssessment(Integer id);

    ArrayList<HashMap<String, Object>> findAllQuizResultsOfUser(Integer user_id);
}
