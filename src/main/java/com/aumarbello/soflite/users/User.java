package com.aumarbello.soflite.users;

import com.aumarbello.soflite.answers.Answer;
import com.aumarbello.soflite.questions.Question;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@ApiModel("Profile information of a user")
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Size(min = 2)
    @ApiModelProperty("Name should have at least two(2) characters")
    private String name;
    private String emailAddress;
    private Date createdAt;

    @OneToMany(mappedBy = "user")
    private List<Question> questions;

    @OneToMany(mappedBy = "user")
    private List<Answer> answers;

    public User(){}

    public User(Long id, String name, String emailAddress, Date createdAt, List<Question> questions, List<Answer> answers) {
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
        this.createdAt = createdAt;
        this.questions = questions;
        this.answers = answers;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
