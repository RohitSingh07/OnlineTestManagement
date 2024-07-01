package com.onlineTestManagement.dto;

import lombok.Data;

@Data
public class CandidateRecordDto {

    private Long questionId;
   private boolean Correct;
    private Long selectedOptionId;
}
