package com.example.certificatequestionspringapi.domain.question.model.repository;

import com.example.certificatequestionspringapi.domain.question.model.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
