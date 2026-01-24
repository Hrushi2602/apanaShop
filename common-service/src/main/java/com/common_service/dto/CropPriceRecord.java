package com.common_service.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CropPriceRecord {

    private String state;
    private String district;
    private String market;
    private String commodity;

    @JsonProperty("modal_price")
    private String modalPrice;

    @JsonProperty("min_price")
    private String minPrice;

    @JsonProperty("max_price")
    private String maxPrice;

    @JsonProperty("arrival_date")
    private String arrivalDate;
}
