package com.onlineTestManagement.dto;

import lombok.Data;

import java.util.List;

@Data
public class QuestionDto {
    private String questionText;
    private List<OptionDto> options;
}
