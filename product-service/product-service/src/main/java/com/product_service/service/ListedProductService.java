package com.product_service.service;


import com.product_service.dto.requests.ListedProductRequest;
import com.product_service.dto.response.ListedProductsResponseDto;
import jakarta.validation.Valid;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface ListedProductService {
    UUID listProduct(@Valid ListedProductRequest listedProductRequest) throws IOException;

    List<ListedProductsResponseDto> getAllListedProduct(UUID categoryId);
}
