package com.example.artfriendly.controller;


import com.example.artfriendly.client.RequestForm;
import com.example.artfriendly.model.OAuthToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final RequestForm requestForm;
    @GetMapping("/oauth/kakao")
    public @ResponseBody String kakaoLogin(@RequestParam(name = "code") String code) throws JsonProcessingException {
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(
                "https://kauth.kakao.com/oauth/token", // https://{요청할 서버 주소}
                HttpMethod.POST, // 요청할 방식
                requestForm.makeRequestTokenForm(code), // 요청할 때 보낼 데이터
                String.class // 요청 시 반환되는 데이터 타입
        );
        ObjectMapper objectMapper = new ObjectMapper();
        OAuthToken oAuthToken = objectMapper.readValue(response.getBody(), OAuthToken.class);
        return oAuthToken.getAccess_token();
    }

    @GetMapping("oauth/kakao/logout")
    public @ResponseBody String kakaoLogout(@RequestHeader(name = "Authorization") String accessToken) throws JsonProcessingException {
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(
                "https://kapi.kakao.com/v1/user/logout",
                HttpMethod.POST,
                requestForm.makeRequestLogoutForm(accessToken),
                String.class // 요청 시 반환되는 데이터 타입
        );
        return response.getBody(); // 로그아웃 아이디 반환됨
    }


    @GetMapping("oauth/kakao/unlink")
    public @ResponseBody String kakaoUnlink(@RequestHeader(name = "Authorization") String accessToken) throws JsonProcessingException {
        System.out.println(accessToken);
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(
                "https://kapi.kakao.com/v1/user/unlink",
                HttpMethod.POST,
                requestForm.makeRequestUnlinkForm(accessToken),
                String.class // 요청 시 반환되는 데이터 타입
        );
        return response.getBody(); // 로그아웃 아이디 반환됨
    }

}
