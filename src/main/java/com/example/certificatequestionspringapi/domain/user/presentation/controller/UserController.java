package com.example.certificatequestionspringapi.domain.user.presentation.controller;

import com.example.certificatequestionspringapi.domain.user.application.UserService;
import com.example.certificatequestionspringapi.domain.user.presentation.dto.request.UserCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody final UserCreateDto userCreateDto) {
        String userSeq = userService.createUser(userCreateDto);

        URI location = URI.create("/api/users/" + userSeq);

        return ResponseEntity.created(location).build();
    }
}
