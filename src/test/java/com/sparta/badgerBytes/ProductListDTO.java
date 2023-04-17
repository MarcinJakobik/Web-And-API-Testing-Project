package com.sparta.badgerBytes;

import com.fasterxml.jackson.annotation.JsonProperty;
public class ProductListDTO {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("price")
    private String price;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("category")
    private CategoryDTO category;
    public int getId() {
        return id; }
    public String getName() {
        return name; }
    public String getPrice() {
        return price; }
    public String getBrand() {
        return brand; }
    public CategoryDTO getCategory() {
        return category; }
    public static class CategoryDTO {
        @JsonProperty("usertype")
        private UserTypeDTO userType;
        @JsonProperty("category")
        private String category;
        public UserTypeDTO getUserType() {
            return userType; }
        public String getCategory() {
            return category; }
    }
    public static class UserTypeDTO {
        @JsonProperty("usertype")
        private String userType;
        public String getUserType() {
            return userType;
        }
    }
}