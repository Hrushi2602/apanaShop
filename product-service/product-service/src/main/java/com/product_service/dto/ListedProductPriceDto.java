package com.product_service.dto;

import com.product_service.entity.UnitType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ListedProductPriceDto {
    private UUID ListedProductPriceId;

    private BigDecimal listingPrice;

    private BigDecimal mrpPrice;

    private Boolean active = true;

    private LocalDateTime createdAt;

    private UUID unitTypeId;
}
