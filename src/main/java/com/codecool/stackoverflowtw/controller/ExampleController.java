package com.codecool.stackoverflowtw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/")
public class ExampleController {
    private final QuestionController questionController;

    @Autowired
    public ExampleController(QuestionController questionController) {
        this.questionController = questionController;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("name", "Example name");
        model.addAttribute("questions", questionController.getAllQuestions());
        return "index";
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

