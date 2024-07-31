package com.example.certificatequestionspringapi.domain.question.presentation.dto.response;

import com.example.certificatequestionspringapi.common.enums.QuestionChapter;
import com.example.certificatequestionspringapi.common.enums.QuestionType;
import lombok.Getter;

import java.util.List;

@Getter
public class MultipleChoiceQuestionResponseDto extends QuestionResponseDto {
    private final List<OptionResponseDto> options;

    public MultipleChoiceQuestionResponseDto(Long questionId, String questionText, QuestionType questionType, QuestionChapter questionChapter, List<OptionResponseDto> options) {
        super(questionId, questionText, questionType, questionChapter);
        this.options = options;
    }
}