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


    Integer rows = 3;
     @Bean
    public String getServiceKey(){
         return serviceKey;
     }
     @Bean
    public Integer getRows(){ return rows;}

}