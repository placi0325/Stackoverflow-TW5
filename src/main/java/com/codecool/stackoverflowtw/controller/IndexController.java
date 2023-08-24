package com.codecool.stackoverflowtw.controller;

import com.codecool.stackoverflowtw.controller.dto.*;
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
    private final UserController userController;
    private final QuestionService questionService;
    private final AnswerService answerService;
    private final AnswerController answerController;
    private final UserService userService;
    private Session session;

    @Autowired
    public IndexController(QuestionController questionController, QuestionService questionService,
                           AnswerService answerService, AnswerController answerController,
                           UserService userService, UserController userController) {
        this.questionController = questionController;
        this.questionService = questionService;
        this.answerService = answerService;
        this.answerController = answerController;
        this.userService = userService;
        this.userController = userController;
        this.session = null;
    }

    @GetMapping
    public String index(Model model, @RequestParam(required = false) HashMap<String,String> allParams) {
        model.addAttribute("questions", questionController.getAllQuestions(allParams.get("order_by")));
        int sessionNumber = session == null ? -1 : session.userId();
        model.addAttribute("sessionNumber", sessionNumber);
        String userName = session == null ? "" : userController.getUserById(session.userId()).username();
        model.addAttribute("userName", userName);
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

    @GetMapping("/logout")
    public String logout(){
        session = null;
        return "redirect:/";
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
        int sessionNumber = session == null ? -1 : session.userId();
        model.addAttribute("sessionNumber", sessionNumber);
        model.addAttribute("answers", answerController.getAllAnswersByQuestionId(id));
        return "question";
    }

    @GetMapping("/delete-question/{id}")
    public String deleteQuestion(@PathVariable int id){
        questionController.deleteQuestionById(id);
        return "redirect:/";
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
        String password = loginDTO.password();
        UserDTO userFromDatabase = userController.login(loginDTO);
        if(userFromDatabase != null){
            if(password.equals(userFromDatabase.password())){
                session = new Session(userFromDatabase.id());
                return "redirect:/";
            }
        }
        return "redirect:/login";
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

