package com.example.artfriendly.controller;

import com.example.artfriendly.application.form.RequestForm;
import com.example.artfriendly.model.dto.UserDto;
import com.example.artfriendly.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestHeader(name = "Authorization") String token) throws JsonProcessingException {
        return ResponseEntity.ok(userService.register(token));
    }

}
