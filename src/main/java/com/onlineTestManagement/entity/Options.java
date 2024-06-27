package com.onlineTestManagement.entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class Options {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long optionId;

    private String optionText;
}
