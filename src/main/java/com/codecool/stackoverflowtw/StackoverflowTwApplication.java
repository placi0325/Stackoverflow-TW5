package com.codecool.stackoverflowtw;

import com.codecool.stackoverflowtw.dao.QuestionsDAO;
import com.codecool.stackoverflowtw.dao.QuestionsDaoJdbc;
import com.codecool.stackoverflowtw.dao.model.Question;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class StackoverflowTwApplication {

    public static void main(String[] args) {
        SpringApplication.run(StackoverflowTwApplication.class, args);
        /* QuestionsDaoJdbc questionsDaoJdbc = new QuestionsDaoJdbc();
        System.out.println("Data created");
        questionsDaoJdbc.create("Mood", "How are you today?", 666);
        questionsDaoJdbc.create("Weather", "Is it raining?", 888);
        questionsDaoJdbc.create("Progress", "Fine and dandy?", 777);
        System.out.println("Listing multiple data");
        List<Question> questionList = questionsDaoJdbc.listAllQuestions();
        for (Question question : questionList) {
            System.out.println(question.getId() + ", " + question.getTitle() + ", " +
                    question.getDescription());
        }*/
    }

    /*@Bean
    public QuestionsDAO questionsDAO() {
        return new QuestionsDaoJdbc();
    }*/
}
