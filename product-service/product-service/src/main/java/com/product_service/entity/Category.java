package com.product_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "cl_productcategorydefn")
public class Category {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    private UUID categoryId;

    @NotBlank(message = "Category name is required")
    private String categoryName;

    @NotBlank(message = "Category code is required")
    private String categoryCode;

    @Builder.Default
    private Boolean offersApplicable = false;

    @Builder.Default
    private Boolean active = true;

    private String icon;

    private String description;

    @CreationTimestamp
    @Column(name = "crt_date", updatable = false)
    private LocalDateTime createdAt;

}
