package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.dao.model.Answer;
import com.codecool.stackoverflowtw.dao.model.Question;

import java.util.List;

public interface AnswerDAO {
    int create (String description, int questionId, int userId);
    List<Answer> listAllAnswersByQuestionId (int questionId);

    Answer getById (int id);

    boolean deleteById(int id);
}
