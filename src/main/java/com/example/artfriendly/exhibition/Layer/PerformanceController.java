package com.example.artfriendly.exhibition.Layer;

import com.example.artfriendly.exhibition.dto.PerformanceRequestDTO;
import com.example.artfriendly.exhibition.dto.PerformanceResponseDTO;
import com.example.artfriendly.exhibition.responseParser.ResponseParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

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


    @GetMapping("/area/{cPage}/{sido}/{sortStdr}/{rows}")
    public ResponseEntity<String> getPerformanceAreaCPageSidoSortStdr3RowsList(@PathVariable String cPage,@PathVariable String sido,@PathVariable String sortStdr, @PathVariable String rows){
      return performanceService.getPerformanceAreaCPageSidoSortStdr3RowsList(cPage,sido,sortStdr,rows);
    }

//    3. 분야
//    @GetMapping("/realm/{realmCode}")
//    public ResponseEntity<String> getPerformanceRealm3RowsList(@PathVariable String realmCode){
//      PerformanceRequestDTO realmRequestDTO = PerformanceRequestDTO.builder()
//              .realmCode(realmCode)
//              .build();
//      return performanceService.getPerformanceRealmSortStdr3RowsList(realmRequestDTO);
//    }

    @GetMapping("/realm")
    public ResponseEntity<String> getPerformanceExampleRealmList(){
        return performanceService.getPerformanceExampleRealmList();
    }


    //XML 값 DTO Parsing 성공
    @GetMapping("/realm/{realmCode}")
    public ResponseEntity<PerformanceResponseDTO> getPerformanceRealmParsingCodeList(@PathVariable String realmCode) throws IOException {
        PerformanceRequestDTO realmRequestDTO = PerformanceRequestDTO.builder()
                .realmCode(realmCode)
                .build();

        PerformanceResponseDTO response = performanceService.getPerformanceRealmData(realmRequestDTO);
        log.info("response 잘 담겼니?, responsePerforlist: {} ", response.getMsgBody());
        return ResponseEntity.ok(response);
    }

}