package com.onlineTestManagement.repository;

import com.onlineTestManagement.entity.Answer;
import com.onlineTestManagement.entity.Options;
import com.onlineTestManagement.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    Answer findByCorrectOption(Options correctOption);
}
