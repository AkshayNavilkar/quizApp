package com.quiz.app.answer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.quiz.app.answer.model.Answer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer>
{
    @Query(value = "select q.question_id,q.question,a.answer_id,a.answer from answer a, question q where a.question_id = q.question_id and q.question_id = ?1", nativeQuery = true)
    List<String> findAnswerByQuestion_id(Integer question_id);
}
