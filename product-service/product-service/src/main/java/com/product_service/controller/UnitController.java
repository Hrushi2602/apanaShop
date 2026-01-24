package com.product_service.controller;

import com.product_service.dto.Unitdto;
import com.product_service.payload.ApiResponse;
import com.product_service.service.UnitTypeServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/unit")
@RequiredArgsConstructor
public class UnitController {

    private final UnitTypeServices unitTypeServices;


    @GetMapping("/get")
    private ResponseEntity<ApiResponse<List<Unitdto>>> getallUnitType(){

        List<Unitdto> unitdtos = unitTypeServices.getallUnitType();

        ApiResponse<List<Unitdto>> response = new ApiResponse<>(true, "fetch successfully", unitdtos);

        return ResponseEntity.ok(response);

    }


    @PostMapping
    public ResponseEntity<ApiResponse<String>> createUnit(@RequestBody Unitdto unitdto){
            ApiResponse<String>  response  = unitTypeServices.createUnit(unitdto);
            return  ResponseEntity.ok(response);
    }
}
