package com.aumarbello.soflite.answers;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class AnswersDaoService {
    private static List<Answer> answers = new ArrayList<>();
    private Long answersCount = 3L;

    static {
        answers.add(new Answer(1L, "Roy Flemin", new Date(), 1L, null, null));
        answers.add(new Answer(2L, "John Wick", new Date(), 3L, null, null));
        answers.add(new Answer(3L, "Morgan Freeman", new Date(), -2L, null, null));
    }

    public Answer answerQuestion(Answer answer) {
        if (answer.getId() == null) {
            answer.setId(++answersCount);
            answer.setCreatedAt(new Date());
        }

        answers.add(answer);
        return answer;
    }

    public List<Answer> findAllById(Long id) {
        List<Answer> questionsAnswers = new ArrayList<>();

        for (Answer answer: answers){
            if (answer.getQuestion().getId().equals(id)){
                questionsAnswers.add(answer);
            }
        }

        return questionsAnswers;
    }
}
