package com.example.certificatequestionspringapi.domain.user.model.entity;

import com.example.certificatequestionspringapi.common.entities.BaseTime;
import com.example.certificatequestionspringapi.common.enums.QuestionType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USERS")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTime {
    @Id @Column(name = "user_seq")
    private String userSeq;

    @Column(name = "name")
    private String name;

    @Column(name = "level")
    private int level;

    @Column(name = "exp")
    private int exp;

    @Column(name = "select_question_type")
    private QuestionType selectQuestionType;

    @Column(name = "select_question_count")
    private int selectQuestionCount;

    @Builder
    public User(String userSeq, String name) {
        this.userSeq = userSeq;
        this.name = name;
        this.level = 1;
        this.exp = 0;
        this.selectQuestionType = QuestionType.SHORT_ANSWER;
        this.selectQuestionCount = 20;
    }
}
