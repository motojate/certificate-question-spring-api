package com.example.certificatequestionspringapi.domain.question.presentation.dto.request;

import com.example.certificatequestionspringapi.common.enums.QuestionChapter;
import com.example.certificatequestionspringapi.common.enums.QuestionType;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder
public class MultipleChoiceQuestionCreateDto extends QuestionCreateDto {
    private String answer;
    private List<OptionCreateDto> options;

    public MultipleChoiceQuestionCreateDto(String questionText, QuestionType questionType, QuestionChapter questionChapter, String answer, List<OptionCreateDto> options) {
        super(questionText, questionType, questionChapter);
        this.answer = answer;
        this.options = options;
    }
}
