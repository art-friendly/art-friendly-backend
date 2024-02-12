package com.example.artfriendly.service;
import com.example.artfriendly.application.KakaoApi;
import com.example.artfriendly.model.User;
import com.example.artfriendly.model.UserRepository;
import com.example.artfriendly.model.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {
    private final KakaoApi kakaoApi;
    private final UserRepository userRepository;

    public UserDto register(String token) {
        User user =  User.parseFrom( kakaoApi.getUser(token));
        userRepository.save(user);
        return UserDto.from(user);
    }
}
