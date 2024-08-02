package com.example.certificatequestionspringapi.domain.question.model.repository;

import com.example.certificatequestionspringapi.domain.question.model.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    @Query("SELECT a.answerText FROM Answer a WHERE a.question.id = :questionId")
    List<String> findAnswerByQuestionId(Long questionId);
}
