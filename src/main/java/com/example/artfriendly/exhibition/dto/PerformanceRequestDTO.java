package com.example.artfriendly.exhibition.dto;

import lombok.*;

import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PerformanceRequestDTO {

        private ComMsgHeader comMsgHeader;
        //공통
        private Date from;
        private Date to;
        private int cPage;
        private Integer rows;           //int면 null값이 불가능, Integer면 가능
        private String place;
        private double gpsxFrom;
        private double gpsyFrom;
        private double gpsxTo;
        private double gpsyTo;
        private String keyword;
        private int sortStdr;
        //Area
        private String sido;
        private String gugun;
        //Realm
        private String realmCode;
        //세부 조회
        private long seq;

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static class ComMsgHeader{
                private String requestTime;
                private String callBackURI;
        }

}
