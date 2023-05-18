package com.codecool.stackoverflowtw.controller;

import com.codecool.stackoverflowtw.controller.dto.LoginDTO;
import com.codecool.stackoverflowtw.controller.dto.NewAnswerDTO;
import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.NewUserDTO;
import com.codecool.stackoverflowtw.service.AnswerService;
import com.codecool.stackoverflowtw.service.QuestionService;
import com.codecool.stackoverflowtw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@Controller
@RequestMapping("/")
public class IndexController {
    private final QuestionController questionController;
    private final QuestionService questionService;
    private final AnswerService answerService;
    private final UserService userService;

    @Autowired
    public IndexController(QuestionController questionController, QuestionService questionService, AnswerService answerService, UserService userService) {
        this.questionController = questionController;
        this.questionService = questionService;
        this.answerService = answerService;
        this.userService = userService;
    }

    @GetMapping
    public String index(Model model, @RequestParam(required = false) HashMap<String,String> allParams) {
        model.addAttribute("questions", questionController.getAllQuestions(allParams.get("order_by")));
        return "index";
    }

    @GetMapping("/signup")
    public String signupPage(){
        return "signup";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
    @PostMapping("/new-question")
    public String addNewQuestion(@RequestParam HashMap<String,String> allParams){
        System.out.println(allParams.entrySet());
        NewQuestionDTO newQuestionDTO = new NewQuestionDTO(allParams.get("title"), allParams.get("description"),
                Integer.parseInt(allParams.get("user_id")));
        questionService.addNewQuestion(newQuestionDTO);
      return "redirect:/";
    }

    @GetMapping("/question/{id}")
    public String questionPage(Model model, @PathVariable int id) {
        model.addAttribute("question", questionController.getQuestionById(id));
        return "question";
    }

    @PostMapping("/new-answer")
    public String addNewAnswer(@RequestParam HashMap<String,String> allParams){
        System.out.println(allParams.entrySet());
        NewAnswerDTO newAnswerDTO = new NewAnswerDTO(allParams.get("description"),
                Integer.parseInt(allParams.get("question_id")), Integer.parseInt(allParams.get("user_id")));
        answerService.addNewAnswer(newAnswerDTO);
        return "redirect:/";
    }

    @PostMapping("/new-user")
    public String addNewUser(@RequestParam HashMap<String, String> allParams){
        System.out.println(allParams.entrySet());
        NewUserDTO newUserDTO = new NewUserDTO(allParams.get("username"), allParams.get("password"));
        userService.addNewUser(newUserDTO);
        return "redirect:/";
    }

    @PostMapping("/login-user")
    public String loginUser(@RequestParam HashMap<String, String> allParams){
        System.out.println(allParams.entrySet());
        LoginDTO loginDTO= new LoginDTO(allParams.get("username"), allParams.get("password"));
        // Use login method in UserController
        return "redirect:/";
    }
    @GetMapping("/path/{name}")
    public String exampleWithPathVariable(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

    @GetMapping("/param")
    public String exampleWithRequestParam(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }
}

