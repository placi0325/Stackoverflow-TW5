package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.dao.QuestionsDAO;
import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.dao.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuestionService {

    private QuestionsDAO questionsDAO;

    @Autowired
    public QuestionService(QuestionsDAO questionsDAO) {
        this.questionsDAO = questionsDAO;
    }

    public List<QuestionDTO> getAllQuestions() {
        List<Question> questions = questionsDAO.listAllQuestions();
        return questions.stream().map(question -> convertQestionIntoQuestionDTO(question)).toList();
        // TODO
        //return List.of(new QuestionDTO(1, "example title", "example desc", LocalDateTime.now()));
    }

    public QuestionDTO getQuestionById(int id) {
        // TODO
        // call questionsDAO method
        return new QuestionDTO(id, "example title", "example desc", Timestamp.valueOf(LocalDateTime.now()), 0, 1);
    }

    public boolean deleteQuestionById(int id) {
        // TODO
        return false;
    }

    public int addNewQuestion(NewQuestionDTO question) {
        // TODO
        // timestamp, answer_count = 0, user id
        int createdId = 0;
        return createdId;
    }

    private QuestionDTO convertQestionIntoQuestionDTO (Question question){
        return new QuestionDTO(
                question.getId(),
                question.getTitle(),
                question.getDescription(),
                question.getTimestamp(),
                question.getAnswerCount(),
                question.getUserId()
        );
    }
}
