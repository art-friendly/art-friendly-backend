package com.example.artfriendly.exhibition.Layer;

import com.example.artfriendly.exhibition.exhibitionConfig.OpenFeignConfig;
import com.example.artfriendly.exhibition.openFeign.PerformanceFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PerformanceService {

    private final PerformanceFeignClient feignClient;
    private final OpenFeignConfig feignConfig;



}
