package com.onlineTestManagement.controller;

import com.onlineTestManagement.dto.OptionDto;
import com.onlineTestManagement.dto.QuestionDto;
import com.onlineTestManagement.entity.Answer;
import com.onlineTestManagement.entity.Options;
import com.onlineTestManagement.entity.Question;
import com.onlineTestManagement.repository.AnswerRepository;
import com.onlineTestManagement.repository.OptionRepository;
import com.onlineTestManagement.repository.QuestionRepository;
import com.onlineTestManagement.service.QuestionManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class ManageAdminController {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private OptionRepository optionRepository;
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private QuestionManagementService questionManagementService;

    @PostMapping("/add")
    public ResponseEntity<Question> addQuestion(@RequestBody QuestionDto questionDto) {

        Question question = questionManagementService.addQuestion(questionDto);
        return ResponseEntity.ok(question);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long id) {
        String result= questionManagementService.deleteQuestion(id);
      return ResponseEntity.ok(result);
    }
    @PutMapping("/question/{id}")
    public ResponseEntity<String> updateQuestion(@PathVariable Long id, @RequestBody QuestionDto questionDto) {
        String result= String.valueOf(questionManagementService.updateQuestion(id, questionDto));
        return ResponseEntity.status(200).body(result);
    }
    @PutMapping("/options/{id}")
    public ResponseEntity<String> updateOption(@PathVariable Long id, @RequestBody OptionDto optionDto) {
        String result= String.valueOf(questionManagementService.updateOption(id, optionDto));
        return ResponseEntity.status(200).body(result);
    }

    @PostMapping("/save/answer")
    public ResponseEntity<Answer> saveAnswer(@RequestBody Answer answer){
        return new ResponseEntity<>(questionManagementService.saveAnswer(answer),HttpStatus.CREATED);
    }
}
