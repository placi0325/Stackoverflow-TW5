package com.codecool.stackoverflowtw.controller.dto;

import org.hibernate.query.results.TableGroupImpl;

import java.sql.Timestamp;

public record AnswerDTO(int id, String description, Timestamp timestamp, int questionId, int userId) {
}
