package com.product_service.repository;

import com.product_service.entity.ListedProduct;
import com.product_service.entity.ListedProductImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ListedProductImageRepository  extends JpaRepository<ListedProductImages, UUID> {
    List<ListedProductImages> findByListedProduct(ListedProduct product);
}
