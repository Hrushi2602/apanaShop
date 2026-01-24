package com.product_service.repository;

import com.product_service.entity.ListedProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ListedProductDetailsRepository extends JpaRepository<ListedProductDetails, UUID> {
    ListedProductDetails findBysellerCatlogId(UUID sellerCatlogId);
}
