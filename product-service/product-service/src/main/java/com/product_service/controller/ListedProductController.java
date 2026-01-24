package com.product_service.controller;

import com.product_service.dto.requests.ListedProductRequest;
import com.product_service.dto.response.ListedProductsResponseDto;
import com.product_service.payload.ApiResponse;
import com.product_service.service.ListedProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/seller/products")
@AllArgsConstructor
public class ListedProductController {

    private final ListedProductService listedProductService;
    
    @PostMapping
    public ResponseEntity<ApiResponse<?>>  listProduct(@Valid @ModelAttribute ListedProductRequest listedProductRequest){

        try {
        UUID productId = listedProductService.listProduct(listedProductRequest);

        return ResponseEntity.ok(new ApiResponse<>(true, "Product listed successfully",productId));

        }catch (IllegalArgumentException ex){
            return ResponseEntity.badRequest().body(
                    new ApiResponse<>(false, ex.getMessage(), null)
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ApiResponse<>(false,"Something went wrong", null)
            );
        }

    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<ApiResponse<List<ListedProductsResponseDto>>> getAllListedProduct(@PathVariable UUID categoryId){
            try {
                 List<ListedProductsResponseDto> listedProductsResponseDtos  = listedProductService.getAllListedProduct(categoryId);

                 return ResponseEntity.ok(new ApiResponse<>(true, "fecth successfully", listedProductsResponseDtos));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                        new ApiResponse<>(false,"Something went wrong", null)
                );
            }
    }


    }
