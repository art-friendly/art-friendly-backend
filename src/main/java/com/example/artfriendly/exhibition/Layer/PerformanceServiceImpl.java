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


    @Override
    public ResponseEntity<String> getPermancePeriodList() {
        String serviceKey = feignConfig.getServiceKey();
        return performanceFeignClient.getPerformancePeriodList(serviceKey);
    }
}
