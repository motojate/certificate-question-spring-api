package com.example.certificatequestionspringapi.domain.question.model.repository;

import com.example.certificatequestionspringapi.common.enums.QuestionType;
import com.example.certificatequestionspringapi.domain.question.model.entity.QMultipleChoiceQuestion;
import com.example.certificatequestionspringapi.domain.question.model.entity.QOption;
import com.example.certificatequestionspringapi.domain.question.model.entity.QShortAnswerQuestion;
import com.example.certificatequestionspringapi.domain.question.presentation.dto.response.*;
import com.querydsl.core.group.GroupBy;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CustomQuestionRepositoryImpl implements CustomQuestionRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<QuestionResponseDto> findQuestionByQuestionType(QuestionType questionType) {

        return switch (questionType) {
            case SHORT_ANSWER -> fetchShortAnswerQuestions();
            case MULTIPLE_CHOICE -> fetchMultipleChoiceQuestions();
        };
    }

    private List<QuestionResponseDto> fetchShortAnswerQuestions() {
        QShortAnswerQuestion shortAnswerQuestion = QShortAnswerQuestion.shortAnswerQuestion;
        List<ShortAnswerQuestionResponseDto> shortQuestions = jpaQueryFactory
                .select(Projections.constructor(ShortAnswerQuestionResponseDto.class,
                        shortAnswerQuestion.id,
                        shortAnswerQuestion.questionText,
                        shortAnswerQuestion.questionType,
                        shortAnswerQuestion.questionChapter))
                .from(shortAnswerQuestion)
                .fetch();

        return new ArrayList<>(shortQuestions);
    }

    private List<QuestionResponseDto> fetchMultipleChoiceQuestions() {
        QMultipleChoiceQuestion multipleChoiceQuestion = QMultipleChoiceQuestion.multipleChoiceQuestion;
        QOption option = QOption.option;

        List<MultipleChoiceQuestionResponseDto> multipleChoiceQuestions = jpaQueryFactory
                .from(multipleChoiceQuestion)
                .leftJoin(multipleChoiceQuestion.options, option)
                .transform(GroupBy.groupBy(multipleChoiceQuestion.id).list(
                        Projections.constructor(MultipleChoiceQuestionResponseDto.class,
                                multipleChoiceQuestion.id,
                                multipleChoiceQuestion.questionText,
                                multipleChoiceQuestion.questionType,
                                multipleChoiceQuestion.questionChapter,
                                GroupBy.list(Projections.constructor(OptionResponseDto.class,
                                        option.optionText,
                                        option.label)))));

        return new ArrayList<>(multipleChoiceQuestions);
    }
}