package com.springapp.controllers;

import com.springapp.models.Answer;
import com.springapp.models.Question;
import com.springapp.models.Result;
import com.springapp.models.User;
import com.springapp.services.AnswerService;
import com.springapp.services.QuestionService;
import com.springapp.services.ResultService;
import com.springapp.services.UserService;
import com.springapp.services.impl.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
public class AppController {


    private QuestionService questionService;
    private AnswerService answerService;
    private ResultService resultService;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setResultService(ResultService resultService) {
        this.resultService = resultService;
    }

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

    @PostMapping("/test/result")
    public String submit(HttpServletRequest request, Principal principal) {
        List<Question> allQuestions= questionService.getAllQuestions();
        Map<String, String[]> testResults = request.getParameterMap();
        int count = 0;
        //Edit this later
        for (Map.Entry<String, String[]> entry:
             testResults.entrySet()) {
            String correctAnswerId = entry.getKey();
            String[] answerId =entry.getValue();
            if(correctAnswerId == null || answerId == null) break;
           if (Long.parseLong(correctAnswerId) == Long.parseLong(answerId.toString())) {
               count++;
           }
           //End
        }
        boolean testCompleted = allQuestions.size() == count;
        String currentUsername = principal.getName();
        User user = userService.getUser(currentUsername);
        Result result = new Result();
        result.setUser_id(user.getId());
        result.setScore(count);
        result.setComplete(testCompleted);

        return "redirect:/test/result";
    }

    @GetMapping("/test/result")
    public String edit(Model model) {

        return "result";
    }

}
