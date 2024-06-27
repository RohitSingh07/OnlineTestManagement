package com.onlineTestManagement.controller;

import com.onlineTestManagement.dto.CustomerRecordDto;
import com.onlineTestManagement.entity.Question;
import com.onlineTestManagement.repository.OptionRepository;
import com.onlineTestManagement.repository.QuestionRepository;
import com.onlineTestManagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class ManageCustomerController {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private OptionRepository optionRepository;
//    @Autowired
//    private AnswerRepository answerRepository;
    @Autowired
    private CustomerService customerService;

    @GetMapping("/showTest")
    public ResponseEntity<List<Question>> showQuestion(){
        List<Question> questions=customerService.showQuestion();
        if (questions != null && !questions.isEmpty()) {
            return ResponseEntity.ok(questions);
        } else {
            return ResponseEntity.noContent().build();
        }}

    @PostMapping("/customerResponse")
    public ResponseEntity<CustomerRecordDto> addCustomerResponse(@PathVariable Long id, @RequestBody CustomerRecordDto customerRecordDto){

        CustomerRecordDto updatedCustomerRecordDto = customerService.addCustomerResponse(id, customerRecordDto);

        if (updatedCustomerRecordDto != null) {
            return ResponseEntity.ok(updatedCustomerRecordDto);
        } else {
            return ResponseEntity.notFound().build();
        }


    }
}
