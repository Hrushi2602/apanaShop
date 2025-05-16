package com.product_service.helper;

import com.product_service.dto.Categorydto;
import com.product_service.entity.Category;
import lombok.Data;

public class CategoryMapper {
    public static Categorydto toDTO(Category category) {
        return Categorydto.builder()
                .categoryId(category.getCategoryId())
                .categoryName(category.getCategoryName())
                .categoryCode(category.getCategoryCode())
                .isOffersApplicable(category.getOffersApplicable())
                .active(category.getActive())
                .icon(category.getIcon())
                .description(category.getDescription())
                .createdAt(category.getCreatedAt())
                .build();
    }

    public static Category toEntity(Categorydto dto) {
        return Category.builder()
                .categoryId(dto.getCategoryId())
                .categoryName(dto.getCategoryName())
                .categoryCode(dto.getCategoryCode())
                .offersApplicable(dto.getIsOffersApplicable())
                .active(dto.getActive())
                .icon(dto.getIcon())
                .description(dto.getDescription())
                .build(); // CreatedAt will be set by @CreationTimestamp
    }
}
