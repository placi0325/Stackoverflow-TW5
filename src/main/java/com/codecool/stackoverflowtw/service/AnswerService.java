package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.controller.dto.AnswerDTO;
import com.codecool.stackoverflowtw.controller.dto.NewAnswerDTO;
import com.codecool.stackoverflowtw.dao.AnswerDAO;
import com.codecool.stackoverflowtw.dao.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    private AnswerDAO answerDAO;

    @Autowired
    public AnswerService(AnswerDAO answerDAO) {
        this.answerDAO = answerDAO;
    }

    public List<AnswerDTO> getAllAnswers(String parameter) {
        List<Answer> answers = answerDAO.listAllAnswers(parameter);

        return answers.stream().map(this::convertAnswerIntoAnswerDTO).toList();
    }

    public AnswerDTO getAnswerById(int id) {
        Answer answer = answerDAO.getById(id);
        return convertAnswerIntoAnswerDTO(answer);
    }

    public boolean deleteAnswerById(int id) {
        return answerDAO.deleteById(id);
    }

    public int addNewAnswer(NewAnswerDTO answer) {
        return answerDAO.create(answer.description(), answer.questionId(), answer.userId());
    }

    private AnswerDTO convertAnswerIntoAnswerDTO(Answer answer) {
        return new AnswerDTO(
                answer.getId(),
                answer.getDescription(),
                answer.getTimestamp(),
                answer.getQuestionId(),
                answer.getUserId()
        );
    }
}
