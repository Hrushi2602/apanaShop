package com.product_service.service;

import com.product_service.dto.Categorydto;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryService {
    List<Categorydto> getAllProductCategories();

    String createCategory(Categorydto categorydto) throws IOException;

    Optional<Categorydto> getProductCategoriesById(UUID categoryId);
}
