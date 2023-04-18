package com.sparta.badgerBytes.tests;

import com.sparta.badgerBytes.testFramework.model.dto.ProductListDTO;
import com.sparta.badgerBytes.testFramework.controll.ConnectionManager;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.badgerBytes.testFramework.controll.ConnectionManager;
import com.sparta.badgerBytes.testFramework.model.Injector;
import com.sparta.badgerBytes.testFramework.model.dto.ProductListDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductListDTOTests {

    String urlResource;

    private static String urlEndpoint = "/searchProduct";

    String urlQueryParams;

    ProductListDTO productListDTO = new ProductListDTO();

    @BeforeAll
    static void setup(){

    }


//        private static String urlEndpoint = "/searchProduct";

    @Test
    @DisplayName("Check a POST request to searchProduct endpoint without search_product parameter returns 400 bad request")
    void testPostRequestToSearchProductWithoutSearchParam() {
        ProductListDTO productListDTO = Injector.deserialize(new ProductListDTO(), ConnectionManager.Method.POST, urlEndpoint);
        Assertions.assertEquals(400, productListDTO.getResponseCodes());
        Assertions.assertEquals("Bad request, search_product parameter is missing in POST request.", productListDTO.getMessage());
    }

    @Test
    @DisplayName("Check a POST request to searchProduct endpoint with an empty search_product parameter returns 400 bad request")
    void testPostRequestToSearchProductWithEmptySearchParam() {
        Map<String, String> params = new HashMap<>();
        params.put("search_product", "");
        ProductListDTO productListDTO = Injector.deserialize(new ProductListDTO(), ConnectionManager.Method.POST, params, urlEndpoint);
        Assertions.assertEquals(400, productListDTO.getResponseCodes());
        Assertions.assertEquals("Bad request, search_product parameter is missing in POST request.", productListDTO.getMessage());
    }

    @Test
    @DisplayName("Check a POST request to searchProduct endpoint with a search_product parameter returns 200 OK")
    void testPostRequestToSearchProductWithSearchParam() {
        Map<String, String> params = new HashMap<>();
        params.put("search_product", "tshirt");
        ProductListDTO productListDTO = Injector.deserialize(new ProductListDTO(), ConnectionManager.Method.POST, params, urlEndpoint);
        Assertions.assertEquals(200, productListDTO.getResponseCodes());
        Assertions.assertEquals("OK", productListDTO.getMessage());
        assertTrue(productListDTO.getProducts().size() > 0, "Expected more than 0 products in the search results");
    }
}
