package com.codecool.stackoverflowtw.dao.question;

import com.codecool.stackoverflowtw.dao.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Repository
public class QuestionsDaoJdbc implements QuestionsDAO {

    private JdbcTemplate jdbcTemplate;

    private QuestionMapper questionMapper;

    @Autowired
    public QuestionsDaoJdbc(JdbcTemplate jdbcTemplate, QuestionMapper questionMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.questionMapper = questionMapper;
    }


    @Override
    public void create(String title, String description, int userId) {
        Timestamp timestamp = Timestamp.from(Instant.now());
        int ANSWER_COUNT = 0;
        String query = "INSERT INTO questions (title, description, timestamp, answer_count, user_id)" +
                " VALUES(?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, new Object[] {title, description, timestamp, ANSWER_COUNT, userId});
        System.out.println("New question created");
    }

    @Override
    public List<Question> listAllQuestions() {
        String questionsQuery = "SELECT * FROM questions";
        List<Question> questions = jdbcTemplate.query(questionsQuery, questionMapper);
        return questions;
    }

    @Override
    public Question getById(int id) {
        String questionQuery = "SELECT * from questions WHERE id =" + id;
        return jdbcTemplate.query(questionQuery, questionMapper).get(0);
    }

    @Override
    public boolean deleteById(int id) {
        String questionQuery = "DELETE FROM questions WHERE id =" + id;
        return jdbcTemplate.update(questionQuery) == 1;
    }


}
