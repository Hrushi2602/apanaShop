package com.product_service.controller;

import com.cloudinary.Cloudinary;
import com.product_service.dto.Categorydto;
import com.product_service.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;
    private final Cloudinary cloudinary;

    @GetMapping
    public ResponseEntity<List<Categorydto>> getAllProductCategories(){
         List<Categorydto> categorydtos = categoryService.getAllProductCategories();

         return ResponseEntity.ok(categorydtos);
    }

    @PostMapping
    public ResponseEntity<String> createCategory(@ModelAttribute Categorydto categorydto) throws  IOException{

       String message = categoryService.createCategory(categorydto);

       return ResponseEntity.ok(message);

    }




}
