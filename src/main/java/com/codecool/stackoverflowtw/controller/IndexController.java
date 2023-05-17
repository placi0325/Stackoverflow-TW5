package com.codecool.stackoverflowtw.controller;

import com.codecool.stackoverflowtw.controller.dto.NewAnswerDTO;
import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.service.AnswerService;
import com.codecool.stackoverflowtw.service.QuestionService;
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

    @Autowired
    public IndexController(QuestionController questionController, QuestionService questionService, AnswerService answerService) {
        this.questionController = questionController;
        this.questionService = questionService;
        this.answerService = answerService;
    }

    @GetMapping
    public String index(Model model, @RequestParam(required = false) HashMap<String,String> allParams) {
        model.addAttribute("questions", questionController.getAllQuestions(allParams.get("order_by")));
        return "index";
    }

    @PostMapping("/new-question")
    public String addNewQuestion(@RequestParam HashMap<String,String> allParams){
        System.out.println(allParams.entrySet());
        NewQuestionDTO newQuestionDTO = new NewQuestionDTO(allParams.get("title"), allParams.get("description"),
                Integer.parseInt(allParams.get("user_id")));
        questionService.addNewQuestion(newQuestionDTO);
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

