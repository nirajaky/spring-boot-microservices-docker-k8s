package com.nirajaky.OrderService.config;

import com.nirajaky.OrderService.external.decoder.CustomErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }
}

/*
    By default, ErrorDecoder would have been called for any error exception received from different services.
    As we have created CustomErrorDecoder. Then this CustomErrorDecoder will be configured wherever ErrorDecoder is called.
 */
