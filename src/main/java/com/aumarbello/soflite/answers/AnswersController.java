package com.aumarbello.soflite.answers;

import com.aumarbello.soflite.questions.Question;
import com.aumarbello.soflite.questions.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class AnswersController {
    @Autowired
    private AnswerRepository repository;

    @Autowired
    private QuestionsRepository questionsRepository;

    @PostMapping("/questions/{id}/answers")
    public Answer addAnswer(@Valid @RequestBody Answer answer) {
        return repository.save(answer);
    }

//    @GetMapping("/questions/{id}/answers")
//    public List<Answer> retrieveQuestionsAnswers(@PathVariable Long questionId) {
//        // Search should be by question id
//        Optional<Question> question = questionsRepository.findById(questionId);
//        if (!question.isPresent()){
//
//        }
//
//        return repository.findAllById(Collections.singleton(id));
//    }
}
