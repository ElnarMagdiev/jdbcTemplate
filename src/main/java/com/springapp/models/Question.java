package com.springapp.models;

import java.util.List;

public class Question {
    private Long id;
    private String content;
    private List<Answer> answers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Question() {
    }

    public Question(String content) {
        this.content = content;
    }

    public Question(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Question(String content, List<Answer> answers) {
        this.content = content;
        this.answers = answers;
    }

    public Question(Long id, String content, List<Answer> answers) {
        this.id = id;
        this.content = content;
        this.answers = answers;
    }
}
