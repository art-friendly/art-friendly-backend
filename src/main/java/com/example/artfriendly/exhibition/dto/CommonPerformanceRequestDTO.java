package com.example.artfriendly.exhibition.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommonPerformanceRequestDTO {
    private ComMsgHeader comMsgHeader;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ComMsgHeader{
        private String requestTime;
        private String callBackURI;
    }
}
