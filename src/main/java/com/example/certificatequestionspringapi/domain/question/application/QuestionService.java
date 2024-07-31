package com.example.certificatequestionspringapi.domain.question.application;

import com.example.certificatequestionspringapi.common.enums.QuestionType;
import com.example.certificatequestionspringapi.domain.question.model.entity.Answer;
import com.example.certificatequestionspringapi.domain.question.model.entity.MultipleChoiceQuestion;
import com.example.certificatequestionspringapi.domain.question.model.entity.Option;
import com.example.certificatequestionspringapi.domain.question.model.repository.AnswerRepository;
import com.example.certificatequestionspringapi.domain.question.model.repository.QuestionRepository;
import com.example.certificatequestionspringapi.domain.question.presentation.dto.request.MultipleChoiceQuestionCreateDto;
import com.example.certificatequestionspringapi.domain.question.presentation.dto.response.QuestionResponseDto;
import com.example.certificatequestionspringapi.domain.question.presentation.dto.response.ShortAnswerQuestionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public List<QuestionResponseDto> findAll(QuestionType questionType) {
        return questionRepository.findQuestionByQuestionType(questionType);
    }

    @Transactional
    public Long create(MultipleChoiceQuestionCreateDto multipleChoiceQuestionCreateDto) {

        MultipleChoiceQuestion multipleChoiceQuestion = MultipleChoiceQuestion.builder()
                .questionText(multipleChoiceQuestionCreateDto.getQuestionText())
                .questionChapter(multipleChoiceQuestionCreateDto.getQuestionChapter())
                .build();

        List<Option> options = multipleChoiceQuestionCreateDto.getOptions().stream()
                .map(option -> Option.builder()
                        .optionText(option.optionText())
                        .label(option.label())
                        .question(multipleChoiceQuestion)
                        .build())
                .toList();
        multipleChoiceQuestion.addOptions(options);
        Answer answer = Answer.builder()
                .answerText(multipleChoiceQuestionCreateDto.getAnswer())
                .question(multipleChoiceQuestion)
                .build();

        questionRepository.save(multipleChoiceQuestion);
        answerRepository.save(answer);
        return multipleChoiceQuestion.getId();
    }
}
