package com.product_service.dto.requests;

import com.product_service.dto.ListedProductDetailsDto;
import com.product_service.dto.ListedProductImageDto;
import com.product_service.dto.ListedProductPriceDto;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

import java.math.BigInteger;
import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
@Builder
public class ListedProductRequest {
    private BigInteger catelogNumber;
    private Long vendorId;
    private String productName;
    private Boolean deliveryAvaiable;
    private Long deliveryRadiusKm;
    private UUID categoryId;

    private ListedProductPriceDto price;
    private List<MultipartFile> images;
    private ListedProductDetailsDto details;
}
