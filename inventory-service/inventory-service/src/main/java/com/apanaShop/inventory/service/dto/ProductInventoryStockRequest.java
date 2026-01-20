package com.product_service.dto.requests;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInventoryStockRequest {
    private UUID sellerCatlogId;
    private Integer availableQuantity;
    private Integer reservedQuantity;
}
