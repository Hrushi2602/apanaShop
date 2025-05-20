package com.product_service.service.impl;

import com.cloudinary.Cloudinary;
import com.product_service.constant.Messages;
import com.product_service.dto.Categorydto;
import com.product_service.entity.Category;
import com.product_service.helper.CategoryMapper;
import com.product_service.repository.CategoryRepository;
import com.product_service.service.CategoryService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Builder
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final Cloudinary cloudinary;

    @Override
    public List<Categorydto> getAllProductCategories() {
        try{
            List<Category> categories = categoryRepository.findAll();

            if (categories.isEmpty()){
                throw new RuntimeException(Messages.CATEGORY_NOT_FOUND);
            }

            return  categories.stream().map(categoryMapper::toDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String createCategory(Categorydto categorydto)  throws IOException{

        String imageUrl = null;

        if(categorydto.getIconImage() != null && !categorydto.getIconImage().isEmpty()){
            imageUrl = uploadImage(categorydto.getIconImage());
        }

        if(imageUrl != null){
            Category category = Category.builder()
                    .categoryName(categorydto.getCategoryName())
                    .categoryCode(categorydto.getCategoryName().toUpperCase())
                    .description(categorydto.getDescription())
                    .icon(imageUrl)
                    .build();

            categoryRepository.save(category);
        }

        return Messages.CATEGORY_CREATED_SUCCESS;
    }

    @Override
    public Optional<Categorydto> getProductCategoriesById(UUID categoryId) {
        try{
            Optional<Category> categorie = categoryRepository.findById(categoryId);

            return  categorie.map(categoryMapper::toDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String uploadImage(MultipartFile file) throws IOException {
        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), Map.of());
        return uploadResult.get("secure_url").toString();
    }
}
