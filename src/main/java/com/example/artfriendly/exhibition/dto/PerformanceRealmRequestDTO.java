package com.example.artfriendly.exhibition.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

public class PerformanceRealmRequestDTO {

    private CommonPerformanceRequestDTO commonPerformanceRequestDTO;
    private MsgBody msgBody;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MsgBody{
        private Date from;
        private Date to;
        private int cPage;
        private int rows;
        private String place;
        private double gpsxFrom;
        private double gpsyFrom;
        private double gpsxTo;
        private double gpsyTo;
        private String keyword;
        private int sortStdr;

        private String realmCode;
    }

}
