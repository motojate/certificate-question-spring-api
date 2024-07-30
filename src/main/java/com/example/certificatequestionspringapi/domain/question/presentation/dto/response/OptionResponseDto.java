package com.example.certificatequestionspringapi.domain.question.presentation.dto.response;

import com.example.certificatequestionspringapi.common.enums.QuestionLabel;

public record OptionResponseDto(String optionText, QuestionLabel label) {
}
