package com.onlineTestManagement.repository;

import com.onlineTestManagement.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
