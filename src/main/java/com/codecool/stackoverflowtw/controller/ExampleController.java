package com.codecool.stackoverflowtw.controller;

import com.codecool.stackoverflowtw.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.dao.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class ExampleController {
    private final QuestionController questionController;

    @Autowired
    public ExampleController(QuestionController questionController) {
        this.questionController = questionController;
    }

    @GetMapping
    public String index(Model model, @RequestParam(required = false) String order_by) {
        model.addAttribute("name", "Example name");
        model.addAttribute("questions", questionController.getAllQuestions(order_by));
        return "index";
    }
    @PostMapping("/new-question")
    public String addnewQuestion(@ModelAttribute(value = "newQuestion") QuestionDTO question){

      return "index";
    };

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

