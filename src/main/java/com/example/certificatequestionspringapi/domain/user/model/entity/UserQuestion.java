package com.example.certificatequestionspringapi.domain.user.model.entity;

import com.example.certificatequestionspringapi.common.entities.BaseTime;
import com.example.certificatequestionspringapi.domain.question.model.entity.Question;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER_QUESTION_MAPPING")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserQuestion extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_seq", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;
}
