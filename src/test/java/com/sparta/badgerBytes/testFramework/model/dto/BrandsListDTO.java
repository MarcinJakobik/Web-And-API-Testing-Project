package com.sparta.badgerBytes.testFramework.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * DTO for brand list
 */

public class BrandsListDTO extends SuperDTO {

    @JsonProperty("brands")
    private List<BrandsItem> brands;

    public List<BrandsItem> getBrands(){
        return brands;
    }

    /**
     * Nested class for properties for brands
     */

    public static class BrandsItem{
        @JsonProperty("id")
        private Integer id;

        @JsonProperty("brand")
        private String brand;

        public Integer getId(){
            return id;
        }

        public String getBrand(){
            return brand;
        }
    }


    public int numberOfBrands(){
        return brands.size();
    }

}
