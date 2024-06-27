package com.onlineTestManagement.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

@Entity
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    private String questionText;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private List<Options> options;

    @Override
    public String toString() {
        return "Question{" +
                "id=" + questionId +
                ", text='" + questionText + '\'' +
                '}';
    }

}
