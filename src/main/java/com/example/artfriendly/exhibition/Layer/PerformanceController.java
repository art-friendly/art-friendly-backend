package com.example.artfriendly.exhibition.Layer;

import com.example.artfriendly.exhibition.openFeign.PerformanceFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

  @Slf4j
  @RestController
  @RequiredArgsConstructor
  public class PerformanceController {
    private final PerformanceService performanceService;

    @GetMapping("/period")
    public ResponseEntity<String> getPeriodPerformanceList(){
        return performanceService.getPermancePeriodList();
    }

//    @GetMapping("/area")
//    public ResponseEntity<String> getAreaPerformanceList(@RequestParam String serviceKey){
//      return feignClient.getPerformanceAreaList(serviceKey);
//    }
//    @GetMapping("/period")
//    public ResponseEntity<String> getRealmPerformanceList(@RequestParam String serviceKey){
//      return feignClient.getPerformanceRealmList(serviceKey);
//    }
}
