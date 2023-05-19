package com.codecool.stackoverflowtw.dao.question;

import com.codecool.stackoverflowtw.dao.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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
    public int create(String title, String description, int userId) {
        Timestamp timestamp = Timestamp.from(Instant.now());
        String query = "INSERT INTO questions (title, description, timestamp, user_id)" +
                " VALUES(?, ?, ?, ?)";
        System.out.println("New question created");
        return jdbcTemplate.update(query, new Object[]{title, description, timestamp, userId});
    }

    @Override
    public List<Question> listAllQuestions(String parameter) {
        String questionsQuery = parameter == null ?
                "SELECT questions.*, CAST(COUNT(answers.id) AS integer)AS answer_count " +
                 "FROM questions " +
                 "LEFT JOIN answers ON questions.id = answers.question_id " +
                 "GROUP BY questions.id "

                :

                "SELECT questions.*, CAST(COUNT(answers.id) AS integer)AS answer_count " +
                "FROM questions " +
                "LEFT JOIN answers ON questions.id = answers.question_id " +
                "GROUP BY questions.id " +
                "ORDER BY " + parameter;

        List<Question> questions = jdbcTemplate.query(questionsQuery, questionMapper);
        return questions;
    }

    @Override
    public Optional<Question> getById(int id) {
        String questionQuery = "SELECT questions.*, CAST(COUNT(answers.id) AS integer) AS answer_count " +
                "FROM questions " +
                "LEFT JOIN answers ON questions.id = answers.question_id " +
                "WHERE questions.id = " + id +
                " GROUP BY questions.id ";
        return jdbcTemplate.query(questionQuery, questionMapper).stream().findFirst();
    }

    @Override
    public boolean deleteById(int id) {
        String questionQuery = "DELETE FROM questions WHERE id =" + id;
        return jdbcTemplate.update(questionQuery) == 1;
    }


}
