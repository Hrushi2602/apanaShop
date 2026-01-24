package com.product_service.helper;

import com.product_service.dto.Categorydto;
import com.product_service.entity.Category;
import lombok.Data;
import org.springframework.stereotype.Component;

import static com.product_service.dto.Categorydto.*;

@Component
public class CategoryMapper {
    public Categorydto toDTO(Category category) {
        return builder()
                .categoryId(category.getCategoryId())
                .categoryName(category.getCategoryName())
                .categoryCode(category.getCategoryCode())
                .isOffersApplicable(category.getOffersApplicable())
                .active(category.getActive())
                .iconUrl(category.getIcon())
                .description(category.getDescription())
                .createdAt(category.getCreatedAt())
                .build();
    }

    public Category toEntity(Categorydto dto) {
        return Category.builder()
                .categoryId(dto.getCategoryId())
                .categoryName(dto.getCategoryName())
                .categoryCode(dto.getCategoryCode())
                .offersApplicable(dto.getIsOffersApplicable())
                .active(dto.getActive())
                .icon(dto.getIconUrl())
                .description(dto.getDescription())
                .build(); // CreatedAt will be set by @CreationTimestamp
    }
}
