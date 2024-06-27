package com.onlineTestManagement.service;

import com.onlineTestManagement.dto.CustomerRecordDto;
import com.onlineTestManagement.entity.CustomerRecord;
import com.onlineTestManagement.entity.Question;
import com.onlineTestManagement.repository.CustomerRecordRepository;
import com.onlineTestManagement.repository.OptionRepository;
import com.onlineTestManagement.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private OptionRepository optionRepository;
    @Autowired
    private CustomerRecordRepository customerRecordRepository;
    public List<Question> showQuestion(){
        return Optional.of(questionRepository.findAll())
                .filter(list -> !list.isEmpty())
                .orElseGet(Collections::emptyList);
    }

    public CustomerRecordDto addCustomerResponse(Long id, CustomerRecordDto customerRecordDto){
        Optional<CustomerRecord> customerRecordOptional = customerRecordRepository.findById(id);

        if (customerRecordOptional.isPresent()) {
            CustomerRecord customerRecord = customerRecordOptional.get();

//            customerRecord.setSelectedOption(customerRecordDto.getSelectedOptionId());
            customerRecord.setCorrect(customerRecordDto.isCorrect());
            customerRecordRepository.save(customerRecord);

            CustomerRecordDto updatedCustomerRecordDto = new CustomerRecordDto();
//            updatedCustomerRecordDto.setSelectedOptionId(customerRecord.getSelectedOption());
            updatedCustomerRecordDto.setCorrect(customerRecord.isCorrect());

            return updatedCustomerRecordDto;
        }
        else{
        return null;
        }
    }
}
