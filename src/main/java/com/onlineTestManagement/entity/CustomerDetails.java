/*
package com.onlineTestManagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class CandidateDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String candidateName;
    private String city;
    private String email;
    private Long contact;

    @OneToMany(mappedBy = "record_id")
    private List<CandidateRecord> candidateRecords;


}
*/
