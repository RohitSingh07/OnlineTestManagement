package com.onlineTestManagement.service;

import com.onlineTestManagement.dto.CandidateRecordDto;
import com.onlineTestManagement.dto.OptionDto;
import com.onlineTestManagement.dto.QuestionDto;
import com.onlineTestManagement.entity.*;
import com.onlineTestManagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private OptionRepository optionRepository;
    @Autowired
    private CandidateRecordRepository candidateRecordRepository;
    @Autowired
    private CandidateDetailsRepository candidateDetailsRepository;
    @Autowired
    private AnswerRepository answerRepository;

    public List<Question> showQuestion() {
        return Optional.of(questionRepository.findAll())
                .filter(list -> !list.isEmpty())
                .orElseGet(Collections::emptyList);
    }

    //    public QuestionDto addCandidateResponse(Long id, CandidateRecordDto candidateRecordDto){
//        Optional<CandidateDetails> candidateDetailsOptional = candidateDetailsRepository.findById(id);
//        Question question = questionRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Question not found with id: " + id));
//
//        List<OptionDto> optionDtos = question.getOptions().stream()
//                .map(option -> {
//                    OptionDto optionDto = new OptionDto();
//                    optionDto.setOptionText(option.getOptionText());
////                    optionDto.setCorrect(option.isCorrect());
//                    return optionDto;
//                })
//                .collect(Collectors.toList());
//
//        QuestionDto questionDto = new QuestionDto();
//        questionDto.setQuestionText(question.getQuestionText());
//        questionDto.setOptions(optionDtos);
//
//        return questionDto;
    public CandidateRecordDto addCandidateResponse(CandidateRecordDto candidateRecordDto) {
        Question question = questionRepository.findById(candidateRecordDto.getQuestionId())
                .orElseThrow(() -> new RuntimeException("Question not found with id: " + candidateRecordDto.getQuestionId()));

        Options selectedOption = optionRepository.findById(candidateRecordDto.getSelectedOptionId())
                .orElseThrow(() -> new RuntimeException("Option not found with id: " + candidateRecordDto.getSelectedOptionId()));

        Answer answer = answerRepository.findByCorrectOption(selectedOption);
        CandidateRecord candidateRecord = new CandidateRecord();
        candidateRecord.setCorrect(false);
        if (answer != null && Objects.equals(selectedOption.getOptionId(), answer.getCorrectOption().getOptionId())) {
            candidateRecord.setCorrect(selectedOption.isCorrect());
        }
        candidateRecord.setQuestion(question);
        candidateRecord.setSelectedOption(selectedOption);
        CandidateRecord savedRecord = candidateRecordRepository.save(candidateRecord);
        CandidateRecordDto savedDto = new CandidateRecordDto();
        savedDto.setQuestionId(savedRecord.getQuestion().getQuestionId());
        savedDto.setCorrect(savedRecord.isCorrect());
        savedDto.setSelectedOptionId(savedRecord.getSelectedOption().getOptionId());
        return savedDto;
    }
}
