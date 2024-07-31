package com.example.certificatequestionspringapi.domain.question.presentation.dto.request;

import com.example.certificatequestionspringapi.common.enums.QuestionChapter;
import com.example.certificatequestionspringapi.common.enums.QuestionType;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public abstract class QuestionCreateDto {
    private final String questionText;
    private final QuestionType questionType;
    private final QuestionChapter questionChapter;

    public QuestionCreateDto(String questionText, QuestionType questionType, QuestionChapter questionChapter) {
        this.questionText = questionText;
        this.questionType = questionType;
        this.questionChapter = questionChapter;
    }
}
