package com.product_service.auth;

import java.util.UUID;

public class UserContextHolder {

    private static final ThreadLocal<UUID> currentUserId = new ThreadLocal<>();

    public static UUID getCurrentUserId(){
        return currentUserId.get();
    }

    static void setCurrentUserId(UUID userId){
        currentUserId.set(userId);
    }

    static void clear(){
        currentUserId.remove();
    }

}
