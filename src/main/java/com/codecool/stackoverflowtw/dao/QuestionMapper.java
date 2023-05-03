package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.dao.model.Question;
import org.springframework.jdbc.core.RowMapper;


import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionMapper implements RowMapper<Question> {

    public Question mapRow (ResultSet resultSet, int rowNum) throws SQLException {
        Question question = new Question();
        question.setId(resultSet.getInt("id"));
        question.setTitle(resultSet.getString("title"));
        question.setDescription(resultSet.getString("description"));
        question.setTimestamp(resultSet.getTimestamp("timestamp"));
        question.setAnswerCount(resultSet.getInt("answer_count"));
        question.setUserId(resultSet.getInt("user_id"));
        return new Question();
    }
}
