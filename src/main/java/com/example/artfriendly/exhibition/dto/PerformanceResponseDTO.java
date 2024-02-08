package com.example.artfriendly.exhibition.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JacksonXmlRootElement(localName = "response")
public class PerformanceResponseDTO {

    @JsonProperty("comMsgHeader")
    private ComMsgHeader comMsgHeader;

    @JsonProperty("msgBody")
    private MsgBody msgBody;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ComMsgHeader {
        @JacksonXmlProperty(localName = "RequestMsgID")
        private String requestMsgID;

        @JacksonXmlProperty(localName = "ResponseTime")
        private String responseTime;

        @JacksonXmlProperty(localName = "ResponseMsgID")
        private String responseMsgID;

        @JacksonXmlProperty(localName = "SuccessYN")
        private String successYN;

        @JacksonXmlProperty(localName = "ReturnCode")
        private String returnCode;

        @JacksonXmlProperty(localName = "ErrMsg")
        private String errMsg;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MsgBody {
        @JacksonXmlProperty(localName = "totalCount")
        private int totalCount;

        @JacksonXmlProperty(localName = "cPage")
        private int cPage;

        @JacksonXmlProperty(localName = "rows")
        private int rows;

        @JacksonXmlProperty(localName = "realmCode")
        private String realmCode;

        @JsonProperty("perforList")
        @JacksonXmlProperty(localName = "perforList")
        private List<PerforList> perforList;
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class PerforList {
        @JacksonXmlProperty(localName = "seq")
        private String seq;
        @JacksonXmlProperty(localName = "title")
        private String title;
        @JacksonXmlProperty(localName = "startDate")
        private String startDate;
        @JacksonXmlProperty(localName = "endDate")
        private String endDate;
        @JacksonXmlProperty(localName = "place")
        private String place;
        @JacksonXmlProperty(localName = "realmName")
        private String realmName;
        @JacksonXmlProperty(localName = "area")
        private String area;
        @JacksonXmlProperty(localName = "thumbnail")
        private String thumbnail;
        @JacksonXmlProperty(localName = "gpsX")
        private String gpsX;
        @JacksonXmlProperty(localName = "gpsY")
        private String gpsY;
    }
}
