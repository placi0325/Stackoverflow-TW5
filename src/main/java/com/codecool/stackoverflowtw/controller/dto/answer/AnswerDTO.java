package com.codecool.stackoverflowtw.controller.dto.answer;

import java.sql.Timestamp;

public record AnswerDTO(
        int id,
        String description,
        Timestamp timestamp,
        int questionId,
        int userId
)
{}
