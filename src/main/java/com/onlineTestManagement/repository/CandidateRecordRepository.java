package com.onlineTestManagement.repository;

import com.onlineTestManagement.entity.CandidateRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRecordRepository extends JpaRepository<CandidateRecord, Long> {
}
