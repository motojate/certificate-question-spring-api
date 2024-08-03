package com.example.certificatequestionspringapi.domain.user.application;

import com.example.certificatequestionspringapi.domain.user.model.entity.User;
import com.example.certificatequestionspringapi.domain.user.model.repository.UserRepository;
import com.example.certificatequestionspringapi.domain.user.presentation.dto.request.UserCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public String createUser(UserCreateDto userCreateDto) {
        User user = User.builder()
                .userSeq(userCreateDto.userSeq())
                .name(userCreateDto.name())
                .build();

        userRepository.save(user);

        return user.getUserSeq();
    }

    @Transactional
    public User updateUserExp(String userSeq) {
        return userRepository.updateUserExp(userSeq);
    }

}
