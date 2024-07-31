package com.example.certificatequestionspringapi.domain.question.model.entity;

import com.example.certificatequestionspringapi.common.entities.BaseTime;
import com.example.certificatequestionspringapi.common.enums.QuestionLabel;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "OPTIONS")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Option extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "option_text")
    private String optionText;

    @Enumerated(EnumType.STRING)
    @Column(name = "label")
    private QuestionLabel label;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private MultipleChoiceQuestion question;

    @Builder
    public Option(String optionText, QuestionLabel label, MultipleChoiceQuestion question) {
        this.optionText = optionText;
        this.label = label;
        this.question = question;
    }
}
