package com.example.artfriendly.exhibition.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@JacksonXmlRootElement(localName = "PerformanceResponseDTO")
public class PerformanceResponseDTO {

    @JsonProperty("MsgBody")
    private MsgBody msgBody;
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MsgBody{
        @JsonProperty("totalCount")
        private long totalCount;
        @JsonProperty("from")
        private String from;
        @JsonProperty("to")
        private String to;
        @JsonProperty("cPage")
        private int cPage;
        @JsonProperty("rows")
        private int rows;
        @JsonProperty("place")
        private String place;
        @JsonProperty("gpsxfrom")
        private double gpsxFrom;
        @JsonProperty("gpsyfrom")
        private double gpsyFrom;
        @JsonProperty("gpsxto")
        private double gpsxTo;
        @JsonProperty("gpsyto")
        private double gpsyTo;
        @JsonProperty("keyword")
        private String keyword;
        @JsonProperty("perforList")
        private List<PerforInfo> perforList;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PerforInfo{
        @JsonProperty("seq")
        private long seq;
        @JsonProperty("title")
        private String title;
        @JsonProperty("startDate")
        private String startDate;
        @JsonProperty("endDate")
        private String endDate;
        @JsonProperty("place")
        private String place;
        @JsonProperty("realmName")
        private String realmName;
        @JsonProperty("area")
        private String area;
        @JsonProperty("thumbnail")
        private String thumbnail;
        @JsonProperty("gpsX")
        private double gpsX;
        @JsonProperty("gpsY")
        private double gpsY;
    }
}
