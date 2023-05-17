package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.dao.QuestionsDAO;
import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.dao.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private QuestionsDAO questionsDAO;

    @Autowired
    public QuestionService(QuestionsDAO questionsDAO) {
        this.questionsDAO = questionsDAO;
    }

    public List<QuestionDTO> getAllQuestions(String parameter) {
        List<Question> questions = questionsDAO.listAllQuestions(parameter);
        return questions.stream().map(question -> convertQestionIntoQuestionDTO(question)).toList();
        // TODO
    }


    public QuestionDTO getQuestionById(int id) {
        // TODO
        Question question = questionsDAO.getById(id);
        return convertQestionIntoQuestionDTO(question);
    }

    public boolean deleteQuestionById(int id) {
        // TODO
        return questionsDAO.deleteById(id);
    }

    public void addNewQuestion(NewQuestionDTO question) {
        // TODO
        questionsDAO.create(question.title(), question.description(), question.userId());
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
