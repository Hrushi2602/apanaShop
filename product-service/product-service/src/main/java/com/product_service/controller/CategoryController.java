package com.product_service.controller;

import com.cloudinary.Cloudinary;
import com.product_service.constant.Messages;
import com.product_service.dto.Categorydto;
import com.product_service.payload.ApiResponse;
import com.product_service.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;
    private final Cloudinary cloudinary;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Categorydto>>> getAllProductCategories(){
         List<Categorydto> categorydtos = categoryService.getAllProductCategories();

        ApiResponse<List<Categorydto>> responses = new ApiResponse<>(true, Messages.CATEGORY_CREATED_SUCCESS,categorydtos);
         return ResponseEntity.ok(responses);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<String>> createCategory(@ModelAttribute Categorydto categorydto) throws  IOException{

       String message = categoryService.createCategory(categorydto);

        ApiResponse<String> response = new ApiResponse<>(true, Messages.CATEGORY_CREATED_SUCCESS,null);
       return ResponseEntity.ok(response);

    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<ApiResponse<Categorydto>> getProductCategoriesById(@PathVariable UUID categoryId){
        Optional<Categorydto> categorydto = categoryService.getProductCategoriesById(categoryId);

        if(categorydto.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(true,Messages.CATEGORY_NOT_FOUND,null));
        }

        return ResponseEntity.ok(new ApiResponse<>(true,Messages.CATEGORY_FOUND,categorydto.get()));
    }




}
