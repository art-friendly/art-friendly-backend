package com.example.artfriendly.exhibition.Layer;

import com.example.artfriendly.exhibition.exhibitionConfig.OpenFeignConfig;
import com.example.artfriendly.exhibition.openFeign.PerformanceFeignClient;
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
    public ResponseEntity<String> getPerformanceAreaSidoSortStdr3RowsList(String sido,String sortStdr, String rows) {
        String serviceKey = feignConfig.getServiceKey();
        return performanceFeignClient.getPerformanceAreaSidoSortStdr3RowsList(serviceKey,sido,sortStdr, rows);
    }

    //3. Realm
    @Override
    public ResponseEntity<String> getPerformanceRealmSortStdr3RowsList(String realmCode, String rows) {
        String serviceKey = feignConfig.getServiceKey();
        return performanceFeignClient.getPerformanceRealmList(serviceKey,realmCode,rows);
    }
}
