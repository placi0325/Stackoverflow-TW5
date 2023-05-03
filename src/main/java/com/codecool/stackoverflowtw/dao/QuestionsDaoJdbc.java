package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.dao.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
@Repository
public class QuestionsDaoJdbc implements QuestionsDAO {

    //private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    private QuestionMapper questionMapper;

    @Autowired
    public QuestionsDaoJdbc(JdbcTemplate jdbcTemplate, QuestionMapper questionMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.questionMapper = questionMapper;
    }




    /*public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }*/

    @Override
    public void create(String title, String description, int userId) {
        String query = "INSERT INTO question (title, description, timestamp, answer_count, user_id" +
                " VALUES(?, ?, ?, ?, ?)";
        Timestamp timestamp = Timestamp.from(Instant.now());
        int ANSWER_COUNT = 0;
        jdbcTemplate.update(query, title, description, timestamp, ANSWER_COUNT, userId);
        System.out.println("New question created");
    }

    @Override
    public List<Question> listAllQuestions() {
        String questionsQuery = "SELECT * FROM questions";
        List<Question> questions = jdbcTemplate.query(questionsQuery, questionMapper);
        return questions;
    }
}
