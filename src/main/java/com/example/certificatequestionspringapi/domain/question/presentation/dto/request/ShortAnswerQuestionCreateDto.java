package com.example.certificatequestionspringapi.domain.question.presentation.dto.request;

import com.example.certificatequestionspringapi.common.enums.QuestionChapter;
import com.example.certificatequestionspringapi.common.enums.QuestionType;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder
public class ShortAnswerQuestionCreateDto extends QuestionCreateDto {
    private List<String> answers;

    public ShortAnswerQuestionCreateDto(String questionText, QuestionType questionType, QuestionChapter questionChapter, List<String> answers) {
        super(questionText, questionType, questionChapter);
        this.answers = answers;
    }
}
