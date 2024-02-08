package com.example.artfriendly.exhibition.Layer;

import com.example.artfriendly.exhibition.dto.PerformanceRequestDTO;
import com.example.artfriendly.exhibition.dto.PerformanceResponseDTO;
import com.example.artfriendly.exhibition.exhibitionConfig.OpenFeignConfig;
import com.example.artfriendly.exhibition.openFeign.PerformanceFeignClient;
import com.example.artfriendly.exhibition.responseParser.ResponseParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class PerformanceServiceImpl implements PerformanceService {
    private final PerformanceFeignClient performanceFeignClient;
    private final OpenFeignConfig feignConfig;

    //1. Period
    @Override
    public ResponseEntity<String> getPerformancePeriodList() {
        String serviceKey = feignConfig.getServiceKey();
        return performanceFeignClient.getPerformancePeriodList(serviceKey);
    }

    @Override
    public ResponseEntity<String> getPerformancePeriod3RowsList(String rows) {
        String serviceKey = feignConfig.getServiceKey();
        return performanceFeignClient.getPerformancePeriod3RowsList(serviceKey, rows);
    }

    //2. Area
    @Override
    public ResponseEntity<String> getPerformanceAreaList() {
        String serviceKey = feignConfig.getServiceKey();
        return performanceFeignClient.getPerformanceAreaList(serviceKey);
    }

    @Override
    public ResponseEntity<String> getPerformanceAreaCPageSidoSortStdr3RowsList(String cPage,String sido,String sortStdr, String rows) {
        String serviceKey = feignConfig.getServiceKey();
        return performanceFeignClient.getPerformanceAreaCPageSidoSortStdr3RowsList(serviceKey,cPage,sido,sortStdr, rows);
    }


    //3. Realm
    @Override
    public ResponseEntity<String> getPerformanceExampleRealmList() {
        String serviceKey = feignConfig.getServiceKey();
        return performanceFeignClient.getPerformanceExampleRealmList(serviceKey);
    }

    @Override
    public PerformanceResponseDTO getPerformanceRealmData(PerformanceRequestDTO realmRequestDTO) {
        String serviceKey = feignConfig.getServiceKey();
        realmRequestDTO.setRows(feignConfig.getRows());
        ResponseEntity<String> responseEntity = performanceFeignClient.getPerformanceRealmList(serviceKey, realmRequestDTO.getRealmCode(), realmRequestDTO.getRows());

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            String xmlResponse = responseEntity.getBody();
            try {
                return ResponseParser.parseXmlResponse(xmlResponse);
            } catch (Exception e) {
                log.error("Failed to parse XML response: {}", e.getMessage());
                // Handle parsing error
                throw new RuntimeException("Failed to parse XML response", e);
            }
        } else {
            // Handle error response
            throw new RuntimeException("Failed to get performance data. Status code: " + responseEntity.getStatusCodeValue());
        }
    }
}
