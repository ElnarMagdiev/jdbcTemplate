package com.springapp.controllers;

import com.springapp.models.Question;
import com.springapp.services.AnswerService;
import com.springapp.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/edit")
public class EditController {

    private QuestionService questionService;
    private AnswerService answerService;

    @GetMapping("/")
    public String edit(Model model) {
        List<Question> questions = questionService.getAllQuestions();
        if (!questions.isEmpty()) {
            for (Question question: questions) {
                question.setAnswers(answerService.getAnswersByQuestionId(question.getId()));
            }
        }
        model.addAttribute("questions", questions);
        return "edit";
    }

    @GetMapping("/{question}")
    public String questionEditForm(@PathVariable Question question, Model model) {
        model.addAttribute("question", question);
        return "questionEdit";
    }

    @GetMapping("/add")
    public String addQuestion(Model model) {

        return "addQuestion";
    }

    @PostMapping("/add")
    public String saveQuestion(Model model) {

        return "addQuestion";
    }

    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Autowired
    public void setAnswerService(AnswerService answerService) {
        this.answerService = answerService;
    }
}
