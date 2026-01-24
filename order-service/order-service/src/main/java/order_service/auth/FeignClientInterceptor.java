package com.product_service.auth;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FeignClientInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {

        UUID userId = UserContextHolder.getCurrentUserId();
        if(userId != null){
             requestTemplate.header("x-user-id", userId.toString());
        }
    }
}
