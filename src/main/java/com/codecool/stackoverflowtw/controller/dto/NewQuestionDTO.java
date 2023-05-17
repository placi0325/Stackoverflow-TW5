package com.codecool.stackoverflowtw.controller.dto;

import java.sql.Timestamp;

public record NewQuestionDTO(String title,
                             String description,
                             int userId){}
