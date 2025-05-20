package com.product_service.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ml_listedproductcateloghasprice")
@Builder
public class ListedProductPrice {


    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    private UUID ListedProductPriceId;

    @Column(precision = 10, scale = 2)
    private BigDecimal listingPrice;

    @Column(precision = 10, scale = 2)
    private BigDecimal mrpPrice;

    @Builder.Default
    private Boolean active = true;

    @CreationTimestamp
    @Column(name = "crt_date", updatable = false)
    private LocalDateTime createdAt;


    @ManyToOne
    @JoinColumn(name = "seller_catelog_id")
    private ListedProduct listedProduct;

    @ManyToOne
    @JoinColumn(name = "unit_type_id")
    private UnitType unitType;
}