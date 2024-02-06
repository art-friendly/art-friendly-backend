package com.example.artfriendly.exhibition.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class PerformancePeriodResponse {

    private MsgBody msgBody;
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MsgBody{
        private long totalCount;
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
        private List<PerforInfo> perforList;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PerforInfo{
        private long seq;
        private String title;
        private Date startDate;
        private Date endDate;
        private String place;
        private String realmName;
        private String area;
        private String thumbnail;
        private double gpsX;
        private double gpsY;
    }
}
