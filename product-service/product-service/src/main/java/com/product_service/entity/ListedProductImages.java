package com.product_service.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tl_listedproductcatelogphoto")
public class ListedProductImages {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    private UUID listedCatelogImageId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String links;

    @CreationTimestamp
    @Column(name = "crt_date", updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "seller_catelog_id", nullable = false)
    private ListedProduct listedProduct;
}