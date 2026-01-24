package com.product_service.auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.UUID;

@Component
public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        String userId = request.getHeader("x-user-id");
//        if (userId != null){
//            UserContextHolder.setCurrentUserId(UUID userId);
//        }

        String userIdHeader = request.getHeader("x-user-id");
        if (userIdHeader != null) {
            try {
                UUID userId = UUID.fromString(userIdHeader); // safely parse string to UUID
                UserContextHolder.setCurrentUserId(userId);
            } catch (IllegalArgumentException e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Invalid UUID format in x-user-id header");
                return false;
            }
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

}
