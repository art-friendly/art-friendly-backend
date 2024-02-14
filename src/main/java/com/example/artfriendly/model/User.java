package com.example.artfriendly.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.json.simple.JSONObject;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String sub;
    private String nickname;
    private String bio;
    private String pictureUrl;
     /*
    이후 추가할 할목 :
    관심분야, 담벼락,뱃지,취향테스트 결과
     */
    public static User parseFrom(JSONObject jsonObject) {
       return builder()
                .sub((String) jsonObject.get("sub"))
                .nickname((String) jsonObject.get("nickname"))
                .pictureUrl((String) jsonObject.get("picture"))
                .build();
    }

    public void updateNickname(String newNickname){
        this.nickname = newNickname;
    }
    public void updatePictureUrl(String imageUrl){
        this.pictureUrl = imageUrl;
    }


}
