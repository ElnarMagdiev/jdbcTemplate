package com.springapp.controllers;

import com.springapp.models.Answer;
import com.springapp.models.Question;
import com.springapp.services.AnswerService;
import com.springapp.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/{questionId}")
    public String questionEditForm(@PathVariable Long questionId, Model model) {
        Question question = questionService.getQuestionById(questionId);
        question.setAnswers(answerService.getAnswersByQuestionId(questionId));
        model.addAttribute("question", question);
        return "questionEdit";
    }

    @GetMapping("/add")
    public String addQuestion() {
        return "addQuestion";
    }

    @PostMapping("/add")
    public String saveQuestion(@RequestParam Map<String, String> param, Model model) {
        for (Map.Entry<String, String> entry:param.entrySet()) {
            String content = entry.getValue();
            if (!content.isEmpty()) {
                Question question = new Question(content);
                Long id = questionService.add(question);
                question.setId(id);
                model.addAttribute("question", question);
                return  "redirect:/edit/add/" + question.getId() + "/answers";
            }
        }
        return  "redirect:/edit/add";
    }

    @GetMapping("/add/{questionId}/answers")
    public String addAnswers(@PathVariable Long questionId, Model model) {
        Question question = questionService.getQuestionById(questionId);
        model.addAttribute("question", question);
        return "addAnswers";
    }

    @PostMapping("/add/{question}/answers")
    public String saveAnswers(@PathVariable Question question, HttpServletRequest request) {
        long questionId = Integer.parseInt(request.getParameter("id_question"));
        for (int i = 0; i < 4; i++) {
            String content = request.getParameter("answer_content_" + i);
            boolean isCorrect = false;
            String correctAnswerId = null;
            if ((correctAnswerId = request.getParameter("answer_isCorrect")) != null) {
                if (Integer.parseInt(correctAnswerId) == i) {
                    isCorrect = true;
                }
            }
            Answer answer = new Answer(questionId, content, isCorrect);
            answerService.add(answer);
        }


        return "redirect:/edit/";
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
