package com.onlineTestManagement.repository;

import com.onlineTestManagement.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
