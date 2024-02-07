package com.example.artfriendly.exhibition.exhibitionConfig;

import feign.codec.Decoder;
import feign.optionals.OptionalDecoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class OpenFeignConfig {

    @Value("${korea.culture.api.key}")
    String serviceKey;

     @Bean
    public String getServiceKey(){
         return serviceKey;
     }

    //값을 xml에서 PerformanceResponseDTO를 통해 Java로 반환
//    @Bean
//    public Decoder feignDecoder() {
//        HttpMessageConverter<?> jacksonConverter = new MappingJackson2XmlHttpMessageConverter();
//        List<HttpMessageConverter<?>> converters = new ArrayList<>();
//        converters.add(jacksonConverter);
//        ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(converters);
//        return new OptionalDecoder(new ResponseEntityDecoder(new SpringDecoder(objectFactory)));
//   }
}