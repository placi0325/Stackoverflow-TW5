package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.dao.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Repository
public class AnswerDaoJdbc implements AnswerDAO {

    private AnswerMapper answerMapper;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AnswerDaoJdbc(AnswerMapper answerMapper, JdbcTemplate jdbcTemplate) {
        this.answerMapper = answerMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int create(String description, int questionId, int userId) {
        Timestamp timestamp = Timestamp.from(Instant.now());
        String query = "INSERT INTO answers (description, time_stamp, question_id, user_id)" + " VALUES (?,?,?,?)";
        int rowsAffected = jdbcTemplate.update(query, new Object[]{description, timestamp, questionId, userId});
        System.out.println("New answer created");
        return rowsAffected;
    }

    @Override
    public List<Answer> listAllAnswersByQuestionId(int questionId) {
        String answerQuery = "SELECT * FROM answers WHERE question_id = " + questionId;
        System.out.println(jdbcTemplate.query(answerQuery, answerMapper));
        return jdbcTemplate.query(answerQuery, answerMapper);
    }

    @Override
    public Answer getById(int id) {
        String answerQuery = "SELECT * FROM answers WHERE id = " + id;
        return jdbcTemplate.query(answerQuery, answerMapper).get(0);
    }

    @Override
    public boolean deleteById(int id) {
        String answerQuery = "DELETE * FROM answers WHERE id = " + id;
        return jdbcTemplate.update(answerQuery) == 1;
    }
}
