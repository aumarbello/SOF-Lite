package com.aumarbello.soflite.answers;

import com.aumarbello.soflite.questions.Question;
import com.aumarbello.soflite.users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Answer {
    @Id
    @GeneratedValue
    private Long id;
    @Size(min = 10)
    private String answer;
    private Date createdAt;
    private Long voteCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Question question;

    public Answer(){}

    public Answer(Long id, String answer, Date createdAt, Long voteCount, User user, Question question) {
        this.id = id;
        this.answer = answer;
        this.createdAt = createdAt;
        this.voteCount = voteCount;
        this.user = user;
        this.question = question;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setVoteCount(Long voteCount) {
        this.voteCount = voteCount;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Long getVoteCount() {
        return voteCount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
