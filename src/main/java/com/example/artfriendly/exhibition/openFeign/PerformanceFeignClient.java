package com.example.artfriendly.exhibition.openFeign;

import com.example.artfriendly.exhibition.exhibitionConfig.OpenFeignConfig;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "PerformanceService", url = "http://www.culture.go.kr", configuration = OpenFeignConfig.class)
public interface PerformanceFeignClient {



    //1. 기간 별
    @GetMapping(value = "/openapi/rest/publicperformancedisplays/period")
    ResponseEntity<String> getPerformancePeriodList(@RequestParam String serviceKey);
    
   //2. 지역 별
   @GetMapping(value = "/openapi/rest/publicperformancedisplays/area")
   ResponseEntity<String> getPerformanceAreaList(@RequestParam String serviceKey);

   //3. 분야 별
   @GetMapping(value = "/openapi/rest/publicperformancedisplays/realm")
   ResponseEntity<String> getPerformanceRealmList(@RequestParam String serviceKey);

}
