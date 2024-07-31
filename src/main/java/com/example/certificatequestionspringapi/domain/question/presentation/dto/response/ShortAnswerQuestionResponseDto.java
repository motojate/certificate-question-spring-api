package com.example.certificatequestionspringapi.domain.question.presentation.dto.response;

import com.example.certificatequestionspringapi.common.enums.QuestionChapter;
import com.example.certificatequestionspringapi.common.enums.QuestionType;
import lombok.Getter;

@Getter
public class ShortAnswerQuestionResponseDto extends QuestionResponseDto {

    public ShortAnswerQuestionResponseDto(Long questionId, String questionText, QuestionType questionType, QuestionChapter questionChapter) {
        super(questionId, questionText, questionType, questionChapter);
    }
}
