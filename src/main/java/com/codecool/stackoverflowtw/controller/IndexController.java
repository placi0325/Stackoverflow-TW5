package com.codecool.stackoverflowtw.controller;

import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
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

    @Autowired
    public IndexController(QuestionController questionController, QuestionService questionService) {
        this.questionController = questionController;
        this.questionService = questionService;
    }

    @GetMapping
    public String index(Model model, @RequestParam(required = false) HashMap<String, String> allParams) {
        model.addAttribute("questions", questionController.getAllQuestions(allParams.get("order_by")));
        return "index";
    }

    @PostMapping("/new-question")
    public String addNewQuestion(@RequestParam HashMap<String, String> allParams) {
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

