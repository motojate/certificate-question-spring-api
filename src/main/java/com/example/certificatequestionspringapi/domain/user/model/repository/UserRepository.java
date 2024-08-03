package com.example.certificatequestionspringapi.domain.user.model.repository;

import com.example.certificatequestionspringapi.domain.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query("UPDATE User u SET u.exp = u.exp + 5 WHERE u.userSeq = :userSeq")
    User updateUserExp(String userSeq);
}
