package com.product_service.repository;

import com.product_service.entity.ListedProduct;
import com.product_service.entity.ListedProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ListedProductPriceRepository extends JpaRepository<ListedProductPrice, UUID> {
    ListedProductPrice findByListedProduct(ListedProduct product);
}
