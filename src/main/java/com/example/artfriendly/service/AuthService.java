package com.example.artfriendly.service;

import com.example.artfriendly.application.KakaoApi;
import com.example.artfriendly.model.OAuthToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final KakaoApi kakaoApi;
    public String kakoLogin (String code) throws JsonProcessingException {
        String token = kakaoApi.login(code);

        JSONObject jsonMain = kakaoApi.getUser(token);


        return token;
    }

    public String kakoLogout (String token) throws JsonProcessingException {
        return kakaoApi.logout(token);
    }

    public String kakaoUnlink(String token){
        return kakaoApi.unlink(token);
    }
}
