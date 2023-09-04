package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.dao.answer.AnswerDAO;
import com.codecool.stackoverflowtw.dao.question.QuestionsDAO;
import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.dao.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private QuestionsDAO questionsDAO;
    private AnswerDAO answerDAO;

    @Autowired
    public QuestionService(QuestionsDAO questionsDAO, AnswerDAO answerDAO) {
        this.questionsDAO = questionsDAO;
        this.answerDAO = answerDAO;
    }


    public List<QuestionDTO> getAllQuestions(String parameter) {
        List<Question> questions = questionsDAO.listAllQuestions(parameter);
        return questions.stream().map(question -> convertQuestionIntoQuestionDTO(question)).toList();
        // TODO
    }


    public QuestionDTO getQuestionById(int id) {
        // TODO
        Optional<Question> question = questionsDAO.getById(id);
        return question.isPresent() ? convertQuestionIntoQuestionDTO(question.get()) : null;

    }

    public boolean deleteQuestionById(int id) {
        // TODO
        return questionsDAO.deleteById(id);
    }

    public int addNewQuestion(NewQuestionDTO question) {
        // TODO
        return questionsDAO.create(question.title(), question.description(), question.userId());
    }

    private QuestionDTO convertQuestionIntoQuestionDTO(Question question){
        int answerCount = answerDAO.getAnswerCountByQuestionId(question.getId());
        return new QuestionDTO(
                question.getId(),
                question.getTitle(),
                question.getDescription(),
                question.getTimestamp(),
                answerCount,
                question.getUserId()
        );
    }
}
