package com.example.certificatequestionspringapi.domain.question.model.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@DiscriminatorValue("SHORT_ANSWER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class ShortAnswerQuestion extends Question {
}
