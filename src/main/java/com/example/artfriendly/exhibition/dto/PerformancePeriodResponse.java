package com.example.artfriendly.exhibition.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class PerformanceResponse {

    private Header header;
    private Body body;

    //오류 탐지를 위한 헤더
    public static class Header {
        private String resultCode;
        private String resultMsg;
    }

    //Request
    public static class Body {
        private Items items;
        private String numOfRows;
        private String pageNo;
        private String totalCount;
    }

    public static class Items {
        private List<ExhibitionItem> item;
    }

    public static class ExhibitionItem {
        private String title;
        private String type;
        private String period;
        private String eventPeriod;
        private String eventSite;
        private String charge;
        private String contactPoint;
        private String url;

        @JsonProperty("imageObject")
        private String imageObjectUrl;
        private String description;
        private String viewCount;
    }
}
