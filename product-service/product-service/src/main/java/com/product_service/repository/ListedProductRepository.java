package com.product_service.repository;

import com.product_service.entity.ListedProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ListedProductRepository extends JpaRepository<ListedProduct, UUID> {
//    List<ListedProduct> findByCategoryId(UUID categoryId);

    @Query("SELECT lp FROM ListedProduct lp WHERE lp.category.id = :categoryId")
    List<ListedProduct> findByCategoryId(@Param("categoryId") UUID categoryId);
}
