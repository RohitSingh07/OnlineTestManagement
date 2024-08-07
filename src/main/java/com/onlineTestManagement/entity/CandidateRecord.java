package com.onlineTestManagement.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="candidates_records")
public class CandidateRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long record_id;

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "questionId")
    private Question question;

    private boolean Correct;

    @ManyToOne
    @JoinColumn(name = "selected_option_id", referencedColumnName = "optionId")
    private Options selectedOption;

}
