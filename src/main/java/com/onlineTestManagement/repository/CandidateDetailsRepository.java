package com.onlineTestManagement.repository;

import com.onlineTestManagement.entity.CandidateDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateDetailsRepository extends JpaRepository<CandidateDetails, Long> {
}
