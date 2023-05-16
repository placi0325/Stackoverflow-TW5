package com.codecool.stackoverflowtw.dao.question;

import com.codecool.stackoverflowtw.dao.model.Question;

import javax.sql.DataSource;
import java.util.List;

public interface QuestionsDAO {

    void create (String title, String description, int userId);
    List<Question> listAllQuestions (String parameter);
    Question getById (int id);

    boolean deleteById(int id);
}
