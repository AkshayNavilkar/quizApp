package com.quiz.app.answer.Impl;

import com.quiz.app.answer.model.Answer;
import com.quiz.app.answer.repository.AnswerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AnswerServiceImplTest {

    @Autowired
    private AnswerServiceImpl answerServiceImpl;

    @MockBean
    private AnswerRepository answerRepository;

    @Test
    public void getAnswer() {
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

        Mockito.when(answerRepository.findAll()).thenReturn(answers);
        assertThat(answerServiceImpl.getAnswer()).isEqualTo(answers);
    }

    @Test
    public void insertAnswer() {
        Answer answer = new Answer();
        answer.setAnswer("A");
        answer.setAnswer_id(1);
        answer.setIs_correct(true);
        answer.setQuestion_id(1);

        Mockito.when(answerRepository.save(answer)).thenReturn(answer);
        assertThat(answerServiceImpl.insertAnswer(answer)).isEqualTo(answer);
    }

    @Test
    public void updateAnswer() {
        Answer answer = new Answer();
        answer.setAnswer("B");
        answer.setAnswer_id(1);
        answer.setIs_correct(true);
        answer.setQuestion_id(1);

        Mockito.when(answerRepository.save(answer)).thenReturn(answer);

        answer.setAnswer("A");

        Mockito.when(answerRepository.save(answer)).thenReturn(answer);
        assertThat(answerServiceImpl.updateAnswer(answer, 1)).isEqualTo(answer);
    }

    @Test
    public void findAnswerByQuestion_id() {
        ArrayList<HashMap<String, Object>> al= new ArrayList<>();
        HashMap<String,Object> m= new HashMap<String,Object>();
        HashMap<String,Object> m1= new HashMap<String,Object>();
        HashMap<String,Object> m2= new HashMap<String,Object>();
        HashMap<String,Object> m3= new HashMap<String,Object>();
        m.put("question_id", new Integer(1));
        m.put("question", "abcd");
        m.put("answer_id", new Integer(1));
        m.put("answer","A");

        m1.put("question_id", new Integer(1));
        m1.put("question", "abcd");
        m1.put("answer_id", new Integer(1));
        m1.put("answer","B");

        m2.put("question_id", new Integer(1));
        m2.put("question", "abcd");
        m2.put("answer_id", new Integer(1));
        m2.put("answer","C");

        m3.put("question_id", new Integer(1));
        m3.put("question", "abcd");
        m3.put("answer_id", new Integer(1));
        m3.put("answer","D");

        al.add(new HashMap<>(m));
        al.add(new HashMap<>(m1));
        al.add(new HashMap<>(m2));
        al.add(new HashMap<>(m3));
        List<String> str = new ArrayList<String>();
        List<String> str1 = new ArrayList<String>();
        for(HashMap<String, Object> item: al)
        {
            str.add(item.toString());
        }

        Mockito.when(answerRepository.findAnswerByQuestion_id(1)).thenReturn(str);
        if(answerRepository.findAnswerByQuestion_id(1).equals(str))
            System.out.println("Success");
        else
            System.out.println("Failed");
    }

    @Test
    public void viewAnswer() {
        Answer answer = new Answer();
        answer.setAnswer("B");
        answer.setAnswer_id(1);
        answer.setIs_correct(true);
        answer.setQuestion_id(1);
        Mockito.when(answerRepository.findById(1)).thenReturn(Optional.of(answer));
        assertThat(answerServiceImpl.viewAnswer(1)).isEqualTo(Optional.of(answer));
    }
}