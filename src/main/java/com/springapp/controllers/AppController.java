package com.springapp.controllers;

import com.springapp.models.Answer;
import com.springapp.models.Question;
import com.springapp.models.Result;
import com.springapp.models.User;
import com.springapp.services.AnswerService;
import com.springapp.services.QuestionService;
import com.springapp.services.ResultService;
import com.springapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String submit(HttpServletRequest request, Principal principal, Model model) {
        Map<String, String[]> testResults = request.getParameterMap();
        int count = 0;
        for (Map.Entry<String, String[]> entry :
                testResults.entrySet()) {
            String[] value = entry.getValue();
            if (value.length > 1) break;
            Answer answer = answerService.getAnswerById(Long.parseLong(value[0]));
            if (answer.isCorrect()) {
                count++;
            }
        }
        List<Question> allQuestions= questionService.getAllQuestions();
        boolean testCompleted = allQuestions.size() == count;
        String currentUsername = principal.getName();
        User user = userService.getUser(currentUsername);
        Result result = new Result();
        result.setUser_id(user.getId());
        result.setScore(count);
        result.setComplete(testCompleted);
        Long resultId = resultService.add(result);
        result.setId(resultId);
        model.addAttribute("result", result);
        return "redirect:/test/result/" + resultId;
    }

    @GetMapping("/test/result/{resultId}")
    public String edit(@PathVariable Long resultId, Model model) {
        Result result = resultService.getResultById(resultId);
        int score = result.getScore();
        int questionCount = questionService.getAllQuestions().size();
        User user = userService.getUserByUserId(result.getUser_id());
        boolean complete = result.isComplete();

        model.addAttribute("questionCount", questionCount);
        model.addAttribute("user", user.getUsername());
        model.addAttribute("score", score);
        model.addAttribute("complete", complete);
        model.addAttribute("percent", score * 100/questionCount);
        return "result";
    }

}
