package com.example.artfriendly.exhibition.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PerformanceDetailRequestDTO {
    private CommonPerformanceRequestDTO commonPerformanceRequestDTO;
    private MsgBody msgBody;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MsgBody{
        private long seq;
    }


}
