package com.sparta.badgerBytes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SearchResultDTO {
  @JsonProperty("responseCode")
  private String responseCode;

  @JsonProperty("products")
  private List<Product> products;

  public List<Product> getProducts() {
    return products;
  }

  public int getNumProducts() {
    if (products != null) {
      return products.size();
    } else {
      return 0;
    }
  }

  public static class Product {

    private static class Usertype {
      @JsonProperty("usertype")
      private String usertype;

      public String getUsertype() {
        return usertype;
      }
    }

    private static class Category {
      @JsonProperty("usertype")
      private Usertype usertype;

      @JsonProperty("category")
      private String category;

      public Usertype getUsertype() {
        return usertype;
      }

      public String getCategory() {
        return category;
      }
    }

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private String price;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("category")
    private Category category;

    public Integer getId() {
      return id;
    }

    public String getName() {
      return name;
    }

    public String getPrice() {
      return price;
    }

    public String getBrand() {
      return brand;
    }

    public Category getCategory() {
      return category;
    }
  }
}
