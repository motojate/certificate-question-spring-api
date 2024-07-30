package com.example.certificatequestionspringapi.domain.question.model.repository;

import com.example.certificatequestionspringapi.domain.question.model.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>, CustomQuestionRepository {
}
