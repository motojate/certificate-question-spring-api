package com.example.certificatequestionspringapi.domain.user.application;

import com.example.certificatequestionspringapi.domain.user.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

}
