package com.onlineTestManagement.service;

import com.onlineTestManagement.dto.OptionDto;
import com.onlineTestManagement.dto.QuestionDto;
import com.onlineTestManagement.entity.Answer;
import com.onlineTestManagement.entity.Options;
import com.onlineTestManagement.entity.Question;
import com.onlineTestManagement.repository.AnswerRepository;
import com.onlineTestManagement.repository.OptionRepository;
import com.onlineTestManagement.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class QuestionManagementService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private OptionRepository optionRepository;

    @Autowired private AnswerRepository answerRepository;
    public Question addQuestion(QuestionDto questionDto){
        //create new question and take id
        Question question = new Question();
        question.setQuestionText(questionDto.getQuestionText());
        Question newQuestion = questionRepository.save(question);

        // create and options with questionId
        List<Options> savedOptions = questionDto.getOptions().stream().map(optionDto -> {
            Options option = new Options();
                option.setOptionText(optionDto.getOptionText());
            option.setCorrect(optionDto.isCorrect());
            return optionRepository.save(option);
        }).collect(Collectors.toList());


        // Find the correct option from the list of Options entities
        Options correctOption = savedOptions.stream()
                .filter(Options::isCorrect)
                .findFirst()
                .orElse(null);

        newQuestion.setOptions(savedOptions);
        Question savedQuestion = questionRepository.save(newQuestion);
        Answer answer = new Answer();
        answer.setQuestion(savedQuestion);
//        answer.setOptions(savedQuestion.getOptions().getFirst());
        answer.setCorrectOption(correctOption);
        answerRepository.save(answer);
        return savedQuestion;
    }

    public String deleteQuestion(Long id){
        if (questionRepository.existsById(id)) {
            questionRepository.deleteById(id);
            return "Question deleted successfully";
        } else {
            return "Question not found";
        }
    }
    public Question updateQuestion(Long id, QuestionDto questionDto){
        Question question;
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        if (optionalQuestion.isPresent()) {
            question = optionalQuestion.get();
            question.setQuestionText(questionDto.getQuestionText());
            questionRepository.save(question);
            return question;
        } else {
            return null;
        }
    }
    public Options updateOption(Long id, OptionDto optionDto){
        Options options;
        Optional<Options> optionalOption = optionRepository.findById(id);
        if (optionalOption.isPresent()) {
             options = optionalOption.get();
            options.setOptionText(optionDto.getOptionText());
            optionRepository.save(options);
            return options;
        } else {
            return null;
        }
    }

    public Answer saveAnswer(Answer answer){
        return answerRepository.save(answer);
    }

}
