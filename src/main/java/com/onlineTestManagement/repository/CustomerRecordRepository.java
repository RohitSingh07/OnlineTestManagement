package com.onlineTestManagement.repository;

import com.onlineTestManagement.entity.CustomerRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRecordRepository extends JpaRepository<CustomerRecord, Long> {
}
