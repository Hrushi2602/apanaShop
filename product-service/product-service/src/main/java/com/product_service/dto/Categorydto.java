package com.product_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Categorydto {
    private UUID categoryId;
    private String categoryName;
    private String categoryCode;
    private Boolean isOffersApplicable;
    private Boolean active;
    private MultipartFile iconImage;
    private String iconUrl; // only for response
    private String description;
    private LocalDateTime createdAt;
}
