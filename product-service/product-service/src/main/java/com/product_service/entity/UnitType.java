package com.product_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cl_unittypedefn")
public class UnitType {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    private UUID unitTypeId;

    @NotBlank
    private String unitTypeName;

    @NotBlank
    private String unitTypeCode;

    @CreationTimestamp
    @Column(name = "crt_date", updatable = false)
    private LocalDateTime createdAt;

}
