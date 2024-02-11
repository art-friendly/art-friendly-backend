package com.example.artfriendly.application;

import com.example.artfriendly.application.form.RequestForm;
import com.example.artfriendly.model.OAuthToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class KakaoApi {
    private final RequestForm requestForm;

    public String login(String code) throws JsonProcessingException {
        RestTemplate rt = new RestTemplate();
        ResponseEntity<JSONObject> response = rt.exchange(
                "https://kauth.kakao.com/oauth/token", // https://{요청할 서버 주소}
                HttpMethod.POST, // 요청할 방식
                requestForm.makeRequestTokenForm(code), // 요청할 때 보낼 데이터
                JSONObject.class // 요청 시 반환되는 데이터 타입
        );

       return response.getBody().get("access_token").toString();
    }

    public String logout(String accessToken){
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(
                "https://kapi.kakao.com/v1/user/logout",
                HttpMethod.POST,
                requestForm.makeRequestLogoutForm(accessToken),
                String.class // 요청 시 반환되는 데이터 타입
        );
        return response.getBody();
    }

    public String unlink(String accessToken){
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(
                "https://kapi.kakao.com/v1/user/unlink",
                HttpMethod.POST,
                requestForm.makeRequestUnlinkForm(accessToken),
                String.class // 요청 시 반환되는 데이터 타입
        );
        return response.getBody();
    }

    public JSONObject getUser(String accessToken){
        RestTemplate rt = new RestTemplate();
        ResponseEntity<JSONObject> response = rt.exchange(
                "https://kapi.kakao.com/v2/user/me", // https://{요청할 서버 주소}
                HttpMethod.GET, // 요청할 방식
                requestForm.makeRequestUserInfoForm(accessToken), // 요청할 때 보낼 데이터
                JSONObject.class // 요청 시 반환되는 데이터 타입
        );
        return response.getBody();

    }
}
