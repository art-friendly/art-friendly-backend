package com.example.artfriendly.model.dto;

import com.example.artfriendly.model.OAuthToken;
import lombok.*;
import org.json.simple.JSONObject;

@Getter
@Setter
@AllArgsConstructor
public class OAuthTokenDto {
    private String access_token;
    //private String id_token;
    public static OAuthTokenDto from (JSONObject tokenObject){
        return new OAuthTokenDto((String) tokenObject.get("access_token"));
    }

}
