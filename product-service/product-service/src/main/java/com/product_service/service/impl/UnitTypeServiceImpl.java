package com.product_service.service.impl;

import com.cloudinary.api.exceptions.ApiException;
import com.product_service.dto.Unitdto;
import com.product_service.entity.UnitType;
import com.product_service.payload.ApiResponse;
import com.product_service.repository.UnitRepository;
import com.product_service.service.UnitTypeServices;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Service
@RequiredArgsConstructor
public class UnitTypeServiceImpl implements UnitTypeServices {
    private final UnitRepository unitRepository;

    private final ModelMapper modelMapper;

    @Override
    public ApiResponse<String> createUnit(Unitdto unitdto) {

        if (unitdto.getUnitTypeName() == null || unitdto.getUnitTypeName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unit name is required");
        }

        UnitType unitType = UnitType.builder()
                .unitTypeName(unitdto.getUnitTypeName())
                .unitTypeCode(unitdto.getUnitTypeName().toUpperCase())
                .build();
        unitRepository.save(unitType);

        ApiResponse<String> response = new ApiResponse<>(true, "Unit created", null);

        return  response;

    }

    @Override
    public List<Unitdto> getallUnitType() {

          List<UnitType> unitTypes = unitRepository.findAll();

        return unitTypes.stream()
                .map(unit -> modelMapper.map(unit, Unitdto.class))
                .collect(Collectors.toList());
    }
}
