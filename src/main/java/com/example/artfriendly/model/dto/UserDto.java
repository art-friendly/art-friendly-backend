package com.example.artfriendly.model.dto;

import com.example.artfriendly.model.User;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String nickname;
    private String pictureUrl;

    public static UserDto from (User user) {
        return new UserDto(user.getNickname(), user.getPictureUrl());
    }
}
