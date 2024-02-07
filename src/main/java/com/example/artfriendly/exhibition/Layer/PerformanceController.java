package com.example.artfriendly.exhibition.Layer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

  @Slf4j
  @RestController
  @RequiredArgsConstructor
  public class PerformanceController {
    private final PerformanceService performanceService;


    //1. 기간
    @GetMapping("/period")
    public ResponseEntity<String> getPeriodPerformanceList(){
      return performanceService.getPerformancePeriodList();
    }

    @GetMapping("/period/{rows}")
    public ResponseEntity<String> getPeriodPerformance3RowsList(@PathVariable String rows){
        return performanceService.getPerformancePeriod3RowsList(rows);
    }

    //2. 지역
    @GetMapping("/area")
    public ResponseEntity<String> getAreaPerformanceList(){
      return performanceService.getPerformanceAreaList();
    }


    @GetMapping("/area/{sido}/{sortStdr}/{rows}")
    public ResponseEntity<String> getPerformanceAreaSidoSortStdr3RowsList(@PathVariable String sido,@PathVariable String sortStdr, @PathVariable String rows){
      return performanceService.getPerformanceAreaSidoSortStdr3RowsList(sido,sortStdr, rows);
    }

    //3. 분야
    @GetMapping("/realm/{realmCode}/{rows}")
    public ResponseEntity<String> getPerformanceRealmSortStdr3RowsList(@PathVariable String realmCode,String rows){
      return performanceService.getPerformanceRealmSortStdr3RowsList(realmCode, rows);
    }

//    @GetMapping("/period")
//    public ResponseEntity<String> getRealmPerformanceList(@RequestParam String serviceKey){
//      return feignClient.getPerformanceRealmList(serviceKey);
//    }
}
