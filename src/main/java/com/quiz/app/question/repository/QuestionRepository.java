package com.quiz.app.question.repository;

import com.quiz.app.question.model.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer>
{
    @Query(value = "select * from question where quiz_id = ?1", nativeQuery = true)
    List<Question> findQuestionByQuiz_id(Integer quiz_id);
}
