package com.product_service.service.impl;

import com.product_service.dto.requests.ListedProductRequest;
import com.product_service.dto.response.ListedProductsResponseDto;
import com.product_service.entity.*;
import com.product_service.entity.ListedProductDetails;
import com.product_service.repository.*;
import com.product_service.service.CloudinaryUploader;
import com.product_service.service.ListedProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ListedProductServiceImpl implements ListedProductService {

    private final CategoryRepository categoryRepository;
    private final ListedProductRepository listedProductRepository;
    private final UnitRepository unitRepository;
    private final ModelMapper modelMapper;
    private final ListedProductPriceRepository listedProductPriceRepository;
    private final CloudinaryUploader cloudinaryUploader;
    private final ListedProductImageRepository listedProductImageRepository;
    private final ListedProductDetailsRepository listedProductDetailsRepository;

    @Override
    public UUID listProduct(ListedProductRequest listedProductRequest) throws IOException {

        //category check
        Category category = categoryRepository.findById(listedProductRequest.getCategoryId())
                .orElseThrow(()-> new IllegalArgumentException("Category Not Found"));

         //create main product
        ListedProduct product = ListedProduct.builder()
                .catelogNumber(listedProductRequest.getCatelogNumber())
                .category(category)
                .productName(listedProductRequest.getProductName())
                .vendorId(listedProductRequest.getVendorId())
                .deliveryAvaiable(listedProductRequest.getDeliveryAvaiable())
                .deliveryRadiusKm(listedProductRequest.getDeliveryRadiusKm())
                .build();

        listedProductRepository.save(product);

        //check unittypeid
        UnitType unitType = unitRepository.findById(listedProductRequest.getPrice().getUnitTypeId()).orElseThrow(
                ()-> new IllegalArgumentException("Unit Type Not found")
        );

        //product price
        ListedProductPrice price = ListedProductPrice.builder()
                .listingPrice(listedProductRequest.getPrice().getListingPrice())
                .mrpPrice(listedProductRequest.getPrice().getMrpPrice())
                .unitType(unitType)
                .listedProduct(product)
                .build();

            listedProductPriceRepository.save(price);

            //product images
        for (MultipartFile file: listedProductRequest.getImages()){
            String imageUrl = cloudinaryUploader.uploadImage(file);

            ListedProductImages images = ListedProductImages.builder()
                    .links(imageUrl)
                    .listedProduct(product)
                    .build();

            listedProductImageRepository.save(images);
        }

        //save crop details
       // listedProductRequest d = listedProductRequest.getDetails();

        ListedProductDetails productDetails = ListedProductDetails.builder()
                .sellerCatlogId(product.getSellerCatlogId())
                .cropType(listedProductRequest.getDetails().getCropType())
                .cropVariety(listedProductRequest.getDetails().getCropVariety())
                .description(listedProductRequest.getDetails().getDescription())
                .grade(listedProductRequest.getDetails().getGrade())
                .humidityLevel(listedProductRequest.getDetails().getHumidityLevel())
                .isOrganic(listedProductRequest.getDetails().getIsOrganic())
                .moistureContent(listedProductRequest.getDetails().getMoistureContent())
                .pesticideUsed(listedProductRequest.getDetails().getPesticideUsed())
                .temperature(listedProductRequest.getDetails().getTemperature())
                .harvestDate(listedProductRequest.getDetails().getHarvestDate())
                .expiryDate(listedProductRequest.getDetails().getExpiryDate())
                .build();

        listedProductDetailsRepository.save(productDetails);

        return product.getSellerCatlogId();
    }

    @Override
    public List<ListedProductsResponseDto> getAllListedProduct(UUID categoryId) {

      List<ListedProduct>  products = listedProductRepository.findByCategoryId(categoryId);

      return products.stream().map(product ->{
                 ListedProductPrice price =  listedProductPriceRepository.findByListedProduct(product);
                List<ListedProductImages> images = listedProductImageRepository.findByListedProduct(product);
              ListedProductDetails details =  listedProductDetailsRepository.findBysellerCatlogId(product.getSellerCatlogId());

              return ListedProductsResponseDto.builder()
                      .sellerCatlogId(product.getSellerCatlogId())
                      .productName(product.getProductName())
                      .catelogNumber(product.getCatelogNumber())
                      .deliveryAvaiable(product.getDeliveryAvaiable())
                      .deliveryRadiusKm(product.getDeliveryRadiusKm())
                      .categoryName(product.getCategory().getCategoryName())
                      .price(ListedProductsResponseDto.PriceDTO.builder()
                              .listingPrice(price.getListingPrice())
                              .mrpPrice(price.getMrpPrice())
                              .unitTypeName(price.getUnitType().getUnitTypeName())
                              .build())
                      .imageLinks(images.stream().map(ListedProductImages::getLinks).toList())
                      .details(ListedProductsResponseDto.DetailDTO.builder()
                              .cropType(details.getCropType())
                              .cropVariety(details.getCropVariety())
                              .description(details.getDescription())
                              .harvestDate(details.getHarvestDate())
                              .expiryDate(details.getExpiryDate())
                              .humidityLevel(details.getHumidityLevel())
                              .grade(details.getGrade())
                              .moistureContent(details.getMoistureContent())
                              .temperature(details.getTemperature())
                              .isOrganic(details.getIsOrganic())
                              .pesticideUsed(details.getPesticideUsed())
                              .build())
                      .build();
              }).toList();
    }
}
