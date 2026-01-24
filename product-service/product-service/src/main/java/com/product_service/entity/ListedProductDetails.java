package com.product_service.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tl_listedproductcatloghasbasicdetails")
public class ListedProductDetails {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
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

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
