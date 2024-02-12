package com.example.artfriendly.service;
import com.example.artfriendly.application.KakaoApi;
import com.example.artfriendly.exception.CustomException;
import com.example.artfriendly.exception.ErrorCode;
import com.example.artfriendly.model.User;
import com.example.artfriendly.model.UserRepository;
import com.example.artfriendly.model.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
    public UserDto getUserInfo(Long userId) {
        User user =  userRepository.findById(userId).orElseThrow(
                () -> new CustomException(ErrorCode.USER_NOT_FOUND)
        );
        return UserDto.from(user);
    }
    @Transactional
    public UserDto editUserNickname(Long userId, String newNickname) {
        User user =  userRepository.findById(userId).orElseThrow(
                () -> new CustomException(ErrorCode.USER_NOT_FOUND)
        );
        user.updateNickname(newNickname);
        return UserDto.from(user);
    }
    @Transactional
    public UserDto editUserProfileImage(Long userId, String imageUrl) {
        User user =  userRepository.findById(userId).orElseThrow(
                () -> new CustomException(ErrorCode.USER_NOT_FOUND)
        );
        user.updatePictureUrl(imageUrl);
        return UserDto.from(user);
    }
}
