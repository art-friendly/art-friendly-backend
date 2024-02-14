package com.example.artfriendly.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    ALREADY_EXIST_PHONE_NUMBER(HttpStatus.BAD_REQUEST, "이미 가입된 회원입니다."),
    USER_NOT_FOUND(HttpStatus.BAD_REQUEST, "없는 회원입니다."),
    WRONG_ACCESS(HttpStatus.BAD_REQUEST, "잘못된 접근입니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
