package com.product_service.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ListedProductImageDto {

    private UUID listedCatelogImageId;
    private String links;
    private LocalDateTime createdAt;

}
