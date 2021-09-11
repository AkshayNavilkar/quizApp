package com.quiz.app.assessment.controller;

import com.quiz.app.assessment.model.Assessment;
import com.quiz.app.assessment.model.Result;
import com.quiz.app.assessment.service.AssessmentService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class AssessmentController
{
    @Autowired
    private AssessmentService assessmentService;

    @GetMapping("assessments")
    public Iterable<Assessment> getAssessment()
    {
        return assessmentService.getAssessment();
    }

    @PostMapping("assessment")
    public @ResponseBody Assessment addAssessment(@RequestBody Assessment assessment)
    {
        return assessmentService.addAssessment(assessment);
    }

    @GetMapping("assessment/result/correct/{user_id}")
    public String countCorrect(@PathVariable Integer user_id)
    {
        return assessmentService.countCorrect(user_id);
    }

    @GetMapping("assessment/result/wrong/{user_id}")
    public String countWrong(@PathVariable Integer user_id)
    {
        return assessmentService.countWrong(user_id);
    }

    @GetMapping("assessment/find/{user_id}/{quiz_id}")
    public @ResponseBody
    ArrayList<HashMap<String, Object>> findAssessmentByUseridAndQuizid(@PathVariable Integer user_id, @PathVariable Integer quiz_id) throws JSONException {
        return assessmentService.findAssessment(user_id, quiz_id);
    }

    @GetMapping("assessment/find/result/{user_id}")
    public @ResponseBody ArrayList<HashMap<String, Object>> findQuizResultByUserid(@PathVariable Integer user_id)
    {
        return assessmentService.findAllQuizResultsOfUser(user_id);
    }
}
