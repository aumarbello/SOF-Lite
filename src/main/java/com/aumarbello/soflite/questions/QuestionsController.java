package com.aumarbello.soflite.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class QuestionsController {
    @Autowired
    private QuestionsRepository repository;

    @GetMapping("/questions")
    public List<Question> retrieveAllQuestions() {
        return repository.findAll();
    }

    @GetMapping("/questions/{id}")
    public Question retrieveQuestion(@PathVariable Long id) {
        Optional<Question> question = repository.findById(id);
        if (!question.isPresent()){
            throw new QuestionNotFoundException(id);
        }

        return question.get();
    }

    @PostMapping("/questions")
    public ResponseEntity<Question> createQuestion(@Valid @RequestBody Question question) {
        Question newQuestion = repository.save(question);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newQuestion.getId()).toUri();

        return ResponseEntity.created(location).body(newQuestion);
    }

    @DeleteMapping("/questions/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        try {
            repository.deleteById(id);
        }catch (Exception e) {
            throw new QuestionNotFoundException(id);
        }
    }

    @PutMapping("/questions/{id}/answer/{answerId}")
    public Question answerQuestion(@PathVariable("id") Long questionId, @PathVariable("answerId") Long answerId) {
        //TODO Re-implement
        return repository.getOne(questionId);
    }
}
