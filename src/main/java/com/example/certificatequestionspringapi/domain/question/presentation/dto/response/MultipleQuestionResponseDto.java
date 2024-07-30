package com.example.certificatequestionspringapi.domain.question.presentation.dto.response;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder
public class MultipleQuestionResponseDto extends QuestionResponseDto {
    private final List<OptionResponseDto> options;
}
