package com.product_service.dto;

import com.product_service.entity.Category;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ListedProductDto {
    private UUID sellerCatlogId;

    private BigInteger catelogNumber;

    private Long vendorId;
    private String productName;

    private Boolean deliveryAvaiable;

    private Long deliveryRadiusKm;

    private boolean active= true;

    private LocalDateTime createdAt;

    private Category category;

}
