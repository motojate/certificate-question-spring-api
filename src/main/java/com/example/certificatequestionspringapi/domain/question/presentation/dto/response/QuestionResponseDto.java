package com.example.certificatequestionspringapi.domain.question.presentation.dto.response;

import com.example.certificatequestionspringapi.common.enums.QuestionChapter;
import com.example.certificatequestionspringapi.common.enums.QuestionType;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class QuestionResponseDto {
    private final Long questionId;
    private final String questionText;
    private final QuestionType questionType;
    private final QuestionChapter questionChapter;
}
