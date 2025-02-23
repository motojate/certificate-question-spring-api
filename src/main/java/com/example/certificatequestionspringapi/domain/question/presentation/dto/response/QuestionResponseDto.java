package com.example.certificatequestionspringapi.domain.question.presentation.dto.response;

import com.example.certificatequestionspringapi.common.enums.QuestionChapter;
import com.example.certificatequestionspringapi.common.enums.QuestionType;
import lombok.Getter;

@Getter
public abstract class QuestionResponseDto {
    private final Long questionId;
    private final String questionText;
    private final QuestionType questionType;
    private final QuestionChapter questionChapter;

    public QuestionResponseDto(Long questionId, String questionText, QuestionType questionType, QuestionChapter questionChapter) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.questionType = questionType;
        this.questionChapter = questionChapter;
    }
}
