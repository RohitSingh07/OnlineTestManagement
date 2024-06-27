package com.onlineTestManagement.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToOne
//    @JoinColumn(name = "selected_option_id",referencedColumnName = "optionId")
//    private Options options;

    @OneToOne
    @JoinColumn(name = "correct_option_id",referencedColumnName = "optionId")
    private Options correctOption;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id",referencedColumnName = "questionId")
    private Question question;

}
