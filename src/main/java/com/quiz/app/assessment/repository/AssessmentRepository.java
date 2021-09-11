package com.quiz.app.assessment.repository;

import com.quiz.app.assessment.model.Assessment;
import com.quiz.app.assessment.model.Result;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface AssessmentRepository extends CrudRepository<Assessment, Integer>
{
    /*@Query(nativeQuery = true)
    Result findAssessmentDetails(@Param(name = "user_id") Integer user_id,@Param(name = "user_id") Integer quiz_id);*/



    @Query(value = "select u.user_id, u.username, qz.quiz_id, qz.quiz_name, qn.question, an.answer, an.is_correct from quiz_application.assessment a, quiz_application.user u, quiz_application.answer an, quiz_application.quiz qz, quiz_application.question qn where u.user_id = ?1 and qz.quiz_id = ?2 and a.answer_id = an.answer_id and qn.question_id = an.question_id and a.user_id = u.user_id and qn.quiz_id = qz.quiz_id", nativeQuery = true)
    List<String> findAssessmentDetails(Integer user_id, Integer quiz_id);

    @Query(value = "select count(*) from user u, assessment a, answer an where an.is_correct = 1 and an.answer_id = a.answer_id and u.user_id = a.user_id and u.user_id = ?1", nativeQuery = true)
    String countCorrect(Integer user_id);

    @Query(value = "select count(*) from user u, assessment a, answer an where an.is_correct = 0 and an.answer_id = a.answer_id and u.user_id = a.user_id and u.user_id = ?1", nativeQuery = true)
    String countWrong(Integer user_id);

    @Query(value = "select u.user_id, u.username, qz.quiz_name, qn.question, an.answer, an.is_correct from quiz_application.assessment a, quiz_application.user u, quiz_application.answer an, quiz_application.quiz qz, quiz_application.question qn where u.user_id = ?1 and a.answer_id = an.answer_id and qn.question_id = an.question_id and a.user_id = u.user_id and qn.quiz_id = qz.quiz_id", nativeQuery = true)
    List<String> findAllQuizResultsOfUser(Integer user_id);

}
