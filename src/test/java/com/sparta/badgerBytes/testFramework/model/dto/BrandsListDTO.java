package com.sparta.badgerBytes.testFramework.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * DTO for brand list
 */

public class BrandsListDTO extends SuperDTO {

    @JsonProperty("brands")
    private List<BrandsItem> brands;

    public List<BrandsItem> getBrands() {
        return brands;
    }

    /**
     * Nested class for properties for brands
     */

    public static class BrandsItem {
        @JsonProperty("id")
        private Integer id;

        @JsonProperty("brand")
        private String brand;

        public Integer getId() {
            return id;
        }

        public String getBrand() {
            return brand;
        }
    }

    public int numberOfBrands() {
        return brands.size();
    }

    public boolean checkBrandDuplication() {
        if (brands == null || brands.size() == 0) {
            //logger
            return false;
        }
        int count = brands.size();
        Set<String> tempSet = new HashSet<>();

        for (count = 0; count < brands.size(); count++) {
            String value = String.valueOf(brands.get(count).getBrand());
            if (tempSet.add(value)) {
                continue;
            } else {
                //logger
                return false;
            }
        }
        return true;
    }

    public boolean checkForNonSequentialIds() {
        if (brands == null || brands.size() == 0) {
            //logger
            return false;
        }
        int count = brands.size();
        for (count = 1; count < brands.size(); count++) {
            if (brands.get(count).getId().equals(brands.get(count - 1).getId())) {
                continue;
            } else {
                //logger
                return false;
            }
        }
        return true;
    }

    public boolean checkForDuplicatedIds() {
        if (brands == null || brands.size() == 0) {
            //logger
            return false;
        }
        int count = brands.size();
        Set<Integer> tempSet = new HashSet<>();

        for (count = 0; count < brands.size(); count++) {
            Integer value = Integer.valueOf(brands.get(count).getId());
            if (tempSet.add(value)) {
                continue;
            } else {
                //logger
                return false;
            }
        }
        return true;
    }
}
