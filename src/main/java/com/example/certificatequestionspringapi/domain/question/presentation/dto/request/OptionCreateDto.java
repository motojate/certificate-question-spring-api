package com.example.certificatequestionspringapi.domain.question.presentation.dto.request;

import com.example.certificatequestionspringapi.common.enums.QuestionLabel;

public record OptionCreateDto(String optionText, QuestionLabel label) {
}
