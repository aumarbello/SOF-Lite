package com.aumarbello.soflite.questions;

import com.aumarbello.soflite.answers.Answer;
import com.aumarbello.soflite.answers.AnswersDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Stream;

@Component
public class QuestionsDaoService {
    @Autowired
    AnswersDaoService service;

    private static List<Question> questions = new ArrayList<>();
    private Long questionsCount = 4L;

    static {
        questions.add(new Question(1L, "Who's the creator of Rust", 3L, 1L, new Date(), null, Collections.emptyList()));
        questions.add(new Question(2L, "Who's the fastest man alive", 2L, 1L, new Date(), null, Collections.emptyList()));
        questions.add(new Question(3L, "What's the distance between earth and the moon", 3L, 1L, new Date(), null, Collections.emptyList()));
        questions.add(new Question(4L, "Who's the creator of Javascript", 1L, 1L, new Date(), null, Collections.emptyList()));
    }

    public List<Question> findAll() {
        return questions;
    }

    public Question findOne(Long id) {
        for (Question question : questions) {
            if (question.getId().equals(id))
                return question;
        }

        return null;
    }

    public Question deleteById(Long id) {
        Iterator<Question> iterator = questions.iterator();
        while (iterator.hasNext()) {
            Question question = iterator.next();
            if (question.getId().equals(id)) {
                iterator.remove();
                return question;
            }
        }

        return null;
    }

    public Question save(Question question) {
        if (question.getId() == null) {
            question.setId(++questionsCount);
            question.setCreatedAt(new Date());
        }

        questions.add(question);

        return question;
    }

    public Question markAnswer(Long questionId, Long answerId) {
        //TODO check if answer is for current question
        Question currentQuestion = findOne(questionId);
        Optional<Answer> optionalAnswer = service.findAllById(questionId)
                .stream()
                .filter(answer -> answer.getQuestion().getId().equals(questionId) && answer.getId().equals(answerId))
                .findFirst();

        if (currentQuestion != null && optionalAnswer.isPresent()) {
            int index = questions.indexOf(currentQuestion);

            currentQuestion.setAcceptedAnswer(answerId);
            questions.set(index, currentQuestion);
        }

        return currentQuestion;
    }
}
