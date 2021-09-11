package com.quiz.app.question.Impl;

import com.quiz.app.question.model.Question;
import com.quiz.app.question.repository.QuestionRepository;
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


@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionServiceImplTest {

    @Autowired
    private QuestionServiceImpl questionServiceImpl;

    @MockBean
    private QuestionRepository questionRepository;

    @Test
    public void getQuestion() {
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

        Mockito.when(questionRepository.findAll()).thenReturn(questions);
        assertThat(questionServiceImpl.getQuestion()).isEqualTo(questions);
    }

    @Test
    public void addQuestion() {
        Question question = new Question();
        question.setQuestion_id(1);
        question.setQuestion("Who is God");
        question.setQuiz_id(1);

        Mockito.when(questionRepository.save(question)).thenReturn(question);
        assertThat(questionServiceImpl.addQuestion(question)).isEqualTo(question);
    }

    @Test
    public void findQuestion() {
        Question question = new Question();
        question.setQuestion_id(1);
        question.setQuestion("Who is God");
        question.setQuiz_id(1);

        Mockito.when(questionRepository.findById(1)).thenReturn(java.util.Optional.of(question));
        assertThat(questionServiceImpl.findQuestion(1)).isEqualTo(java.util.Optional.of(question));
    }

    @Test
    public void findQuestionsByQuiz_id() {
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


        Mockito.when(questionRepository.findQuestionByQuiz_id(1)).thenReturn(questions);
        assertThat(questionServiceImpl.findQuestionsByQuiz_id(1)).isEqualTo(questions);
    }
}