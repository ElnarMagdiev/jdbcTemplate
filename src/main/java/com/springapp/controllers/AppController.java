package com.springapp.controllers;

import com.springapp.models.Answer;
import com.springapp.models.Question;
import com.springapp.services.AnswerService;
import com.springapp.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AppController {


    private QuestionService questionService;
    private AnswerService answerService;

    @Autowired
    public void setAnswerService(AnswerService answerService) {
        this.answerService = answerService;
    }

    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/test")
    public String index(Model model) {
        List<Question> questions = questionService.getAllQuestions();
        if (!questions.isEmpty())
        for (Question question: questions) {
            List<Answer> answers = answerService.getAnswersByQuestionId(question.getId());
            if (!answers.isEmpty()) {
                question.setAnswers(answers);
            }
        }
        model.addAttribute("questions", questions);
        return "test";
    }

    @GetMapping("/edit")
    public String edit(Model model) {

        return "test";
    }

}
