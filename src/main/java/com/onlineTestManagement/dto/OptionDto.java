package com.onlineTestManagement.dto;

import lombok.Data;

@Data
public class OptionDto {

    private Long optionId;
    private String optionText;
    private boolean correct;
}
