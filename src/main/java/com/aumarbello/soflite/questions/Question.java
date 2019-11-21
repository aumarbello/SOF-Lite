package com.aumarbello.soflite.questions;

import com.aumarbello.soflite.answers.Answer;
import com.aumarbello.soflite.users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue
    private Long id;
    @Size(min = 10)
    private String question;
    private Long voteCount;
    private Long acceptedAnswer;
    private Date createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    public Question(){}

    public Question(Long id, String question, Long voteCount, Long acceptedAnswer, Date createdAt, User user, List<Answer> answers) {
        this.id = id;
        this.question = question;
        this.voteCount = voteCount;
        this.acceptedAnswer = acceptedAnswer;
        this.createdAt = createdAt;
        this.user = user;
        this.answers = answers;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setVoteCount(Long voteCount) {
        this.voteCount = voteCount;
    }

    public Long getVoteCount() {
        return voteCount;
    }

    public void setAcceptedAnswer(Long acceptedAnswer) {
        this.acceptedAnswer = acceptedAnswer;
    }

    public Long getAcceptedAnswer() {
        return acceptedAnswer;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}
