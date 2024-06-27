package com.onlineTestManagement.dto;

import com.onlineTestManagement.entity.Options;
import com.onlineTestManagement.entity.Question;
import lombok.Data;

@Data
public class CustomerRecordDto {

    private Long questionId;
    private boolean Correct;
    private Long selectedOptionId;
}
