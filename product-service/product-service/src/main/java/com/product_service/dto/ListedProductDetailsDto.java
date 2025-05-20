package com.product_service.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Data
public class ListedProductDetailsDto {

    private UUID ListedProductBasicDetailsId;

    private UUID sellerCatlogId;

    private String  cropType;

    private String  cropVariety;

    private String description;

    private LocalDateTime harvestDate;

    private LocalDateTime expiryDate;

    private String grade;
    private Boolean isOrganic;
    private String pesticideUsed;


    private Double humidityLevel;
    private Double moistureContent;
    private Double temperature;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
