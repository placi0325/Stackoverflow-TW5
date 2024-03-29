package com.codecool.stackoverflowtw.dao.question;

import com.codecool.stackoverflowtw.dao.model.Question;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public interface QuestionsDAO {

    int create (String title, String description, int userId);
    List<Question> listAllQuestions (String parameter);
    Optional<Question> getById (int id);
    boolean deleteById(int id);
}
