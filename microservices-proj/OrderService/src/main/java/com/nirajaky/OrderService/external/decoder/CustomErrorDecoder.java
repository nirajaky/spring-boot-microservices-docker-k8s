package com.nirajaky.OrderService.external.decoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nirajaky.OrderService.exception.CustomException;
import com.nirajaky.OrderService.external.response.ErrorResponse;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {

        ObjectMapper objectMapper = new ObjectMapper();

        // Here response is the object (ErrorResponse object) in which error is sent from Product Service
        log.info("Error Response {} ", response.request().url());
        log.info("Error Response {} ", response.request().headers());

        try {
            ErrorResponse errorResponse = objectMapper.readValue(response.body().asInputStream()
                    , ErrorResponse.class);

            return new CustomException(errorResponse.getErrorMessage(), errorResponse.getErrorCode(),
                    response.status());
        } catch (IOException e) {
            throw new CustomException("Internal Server Error", "INTERNAL_SERVER_ERROR", 500);
        }

    }
}
