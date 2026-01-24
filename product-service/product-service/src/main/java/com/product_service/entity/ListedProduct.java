package com.product_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "ml_sellerhaslistedproductcatelog")
public class ListedProduct {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    private UUID sellerCatlogId;

    @Column(unique = true)
    private BigInteger catelogNumber;

    private Long vendorId;

    @NotBlank(message = "name should required")
    private String productName;

    private Boolean deliveryAvaiable;

    private Long deliveryRadiusKm;

    @Builder.Default
    private boolean active= true;

    @CreationTimestamp
    @Column(name = "crt_date", updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne()
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

}
