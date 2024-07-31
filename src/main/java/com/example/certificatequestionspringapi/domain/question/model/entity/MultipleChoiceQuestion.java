package com.example.certificatequestionspringapi.domain.question.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@DiscriminatorValue("MULTIPLE_CHOICE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class MultipleChoiceQuestion extends Question {
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Option> options;

    public void addOptions(List<Option> optionList) {
        this.options = optionList;
    }
}
