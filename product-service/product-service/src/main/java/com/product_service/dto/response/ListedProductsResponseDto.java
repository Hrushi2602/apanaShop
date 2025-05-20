package com.product_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class  ListedProductsResponseDto  {
    private UUID sellerCatlogId;
    private String productName;
    private BigInteger catelogNumber;
    private Boolean deliveryAvaiable;
    private Long deliveryRadiusKm;

    private String categoryName;

    private PriceDTO price;
    private List<String> imageLinks;
    private DetailDTO details;

    @Data
    @Builder
    public static class PriceDTO {
        private BigDecimal listingPrice;
        private BigDecimal mrpPrice;
        private String unitTypeName;
    }

    @Data
    @Builder
    public static class DetailDTO {
        private String cropType;
        private String cropVariety;
        private String description;
        private LocalDateTime harvestDate;
        private LocalDateTime expiryDate;
        private String grade;
        private Boolean isOrganic;
        private String pesticideUsed;
        private Double humidityLevel;
        private Double moistureContent;
        private Double temperature;
    }
}
