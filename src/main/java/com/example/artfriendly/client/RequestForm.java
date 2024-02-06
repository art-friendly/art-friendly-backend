package com.example.artfriendly.client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@RequiredArgsConstructor
@Component
public class RequestForm {
    @Value("${kakao.grantType}")
    private String grantType;
    @Value("${kakao.clientId}")
    private String clientId;
    @Value("${kakao.clientSecret}")
    private String clientSecret;
    @Value("${kakao.redirectUri}")
    private String redirectUri;
    @Value("${kakao.logout.redirectUri}")
    private String logoutRedirectUri;
    private String code;

    public HttpEntity<MultiValueMap<String, String>>  makeRequestTokenForm(String code){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);
        params.add("redirect_uri", redirectUri);
        params.add("code", code);
        return new HttpEntity<>(params, headers);
    }

    public HttpEntity<MultiValueMap<String, String>>  makeRequestLogoutForm(String accessToken){

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        headers.add("Authorization", accessToken);
        return new HttpEntity<>(headers);
    }

    public HttpEntity<MultiValueMap<String, String>>  makeRequestUnlinkForm(String accessToken){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        headers.add("Authorization", accessToken);
        return new HttpEntity<>(headers);
    }

}