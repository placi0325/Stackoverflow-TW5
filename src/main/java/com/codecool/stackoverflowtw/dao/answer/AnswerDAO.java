package com.codecool.stackoverflowtw.dao.answer;

import com.codecool.stackoverflowtw.dao.model.Answer;

import java.util.List;

public interface AnswerDAO {
    int create (String description, int questionId, int userId);
    List<Answer> listAllAnswersByQuestionId (int questionId);

    int getAnswerCountByQuestionId(int questionId);
    Answer getById (int id);

    boolean deleteById(int id);
}
