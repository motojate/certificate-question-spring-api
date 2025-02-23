package com.example.certificatequestionspringapi.domain.question.model.repository;

import com.example.certificatequestionspringapi.common.enums.QuestionType;
import com.example.certificatequestionspringapi.domain.question.presentation.dto.response.QuestionResponseDto;

import java.util.List;

public interface CustomQuestionRepository {
    List<QuestionResponseDto> findQuestionByQuestionType(QuestionType questionType);
}
