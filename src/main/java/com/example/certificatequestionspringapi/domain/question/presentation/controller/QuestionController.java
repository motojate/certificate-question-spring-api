package com.example.certificatequestionspringapi.domain.question.presentation.controller;

import com.example.certificatequestionspringapi.common.enums.QuestionType;
import com.example.certificatequestionspringapi.domain.question.application.QuestionService;
import com.example.certificatequestionspringapi.domain.question.presentation.dto.request.MultipleChoiceQuestionCreateDto;
import com.example.certificatequestionspringapi.domain.question.presentation.dto.request.ShortAnswerQuestionCreateDto;
import com.example.certificatequestionspringapi.domain.question.presentation.dto.response.QuestionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/questions")
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping
    public ResponseEntity<List<QuestionResponseDto>> getQuestions(@RequestParam("questionType") QuestionType questionType) {
        return ResponseEntity.ok(questionService.findAll(questionType));
    }

    @PostMapping("/multiple-choice")
    public ResponseEntity<Long> generateMultipleQuestion(@RequestBody MultipleChoiceQuestionCreateDto multipleChoiceQuestionCreateDto) {
        Long questionId = questionService.createMultipleChoiceQuestion(multipleChoiceQuestionCreateDto);

        URI location = URI.create("/api/questions/%d" + questionId);

        return ResponseEntity.created(location).body(questionId);
    }

    @PostMapping("/short-answer")
    public ResponseEntity<Long> generateShortAnswerQuestion(@RequestBody ShortAnswerQuestionCreateDto shortAnswerQuestionCreateDto) {
        Long questionId = questionService.createShortAnswerQuestion(shortAnswerQuestionCreateDto);

        URI location = URI.create("/api/questions/%d" + questionId);

        return ResponseEntity.created(location).body(questionId);
    }
}
