package com.product_service.service;

import com.product_service.dto.Unitdto;
import com.product_service.payload.ApiResponse;

import java.util.List;

public interface UnitTypeServices {
    ApiResponse<String> createUnit(Unitdto unitdto);

    List<Unitdto> getallUnitType();
}
