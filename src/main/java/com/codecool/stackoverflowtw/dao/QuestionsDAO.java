package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.dao.model.Question;

import javax.sql.DataSource;
import java.util.List;

public interface QuestionsDAO {
    // public void setDataSource (DataSource dataSource);
    public void create (String title, String description, int userId);
    public List<Question> listAllQuestions ();
}
