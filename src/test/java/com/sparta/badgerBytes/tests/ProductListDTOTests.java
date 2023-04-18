package com.sparta.badgerBytes.tests;

import com.sparta.badgerBytes.testFramework.model.dto.ProductListDTO;
import com.sparta.badgerBytes.testFramework.controll.ConnectionManager;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.badgerBytes.testFramework.controll.ConnectionManager;
import com.sparta.badgerBytes.testFramework.model.Injector;
import com.sparta.badgerBytes.testFramework.model.dto.ProductListDTO;
import org.junit.jupiter.api.*;

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

    private static String urlEndpoint; //conflict here

    private static String accessMethod;


    private static String urlQueryParams;

    private static ProductListDTO productListDTOPost = new ProductListDTO();
    private static ProductListDTO productListDTOGet = new ProductListDTO();

    @BeforeAll
    static void setupPOST() {

        urlEndpoint = "productsList"; //conflict here
        Map<String, String> products = new HashMap<>(Map.of("id", "1"));
        productListDTOPost = Injector.deserialize(productListDTOPost, ConnectionManager.Method.POST, products, urlEndpoint);
        productListDTOGet = Injector.deserialize(productListDTOGet, ConnectionManager.Method.GET, urlEndpoint);
    }

    @Nested
    @Order(1)
    @DisplayName("POST method tests")
    class PostMethod {

        @Test
        @Order(1)
        @DisplayName("1. Test POST method body response code")
        void testPostMethodBodyResponseCode() {
            Assertions.assertEquals(405, productListDTOPost.getResponseCode());
        }

        @Test
        @Order(2)
        @DisplayName("2. Test POST body response message")
        void testPostBodyResponseMessage() {
            Assertions.assertEquals("This request method is not supported.", productListDTOPost.getMessage());
        }

        @Test
        @Order(3)
        @DisplayName("3. Test if there is no products for POST method")
        void testIfThereIsNoProductsForPostMethod() {
            Assertions.assertNull(productListDTOPost.getProducts());

        }

        @Test
        @Order(4)
        @DisplayName("4. Test number of products for POST method")
        void testNumberOfProductsForPostMethod() {
            Assertions.assertEquals(0, productListDTOPost.getNumProducts());
        }

        @Test
        @Order(5)
        @DisplayName("5. Test number of search results for POST method")
        void testNumberOfSearchResultsForPostMethod() {
            Assertions.assertEquals(0, productListDTOPost.getNumSearchResults());
        }

        @Test
        @Order(6)
        @DisplayName("6. Test search result for POST method")
        void testSearchResultForPostMethod() {
            Assertions.assertNull(productListDTOPost.getSearchResults());
        }

    }

    @Nested
    @DisplayName("POST method for searching products")
    class PostMethodForSearchingProducts {
        @Test
        @DisplayName("Check a POST request to searchProduct endpoint without search_product parameter returns 400 bad request")
        void testPostRequestToSearchProductWithoutSearchParam() {
            ProductListDTO productListDTO = Injector.deserialize(new ProductListDTO(), ConnectionManager.Method.POST, "searchProduct");
            Assertions.assertEquals(400, productListDTO.getResponseCode());
            Assertions.assertEquals("Bad request, search_product parameter is missing in POST request.", productListDTO.getMessage());
        }

        @Test
        @DisplayName("Check a POST request to searchProduct endpoint with an empty search_product parameter returns 400 bad request")
        void testPostRequestToSearchProductWithEmptySearchParam() {
            ProductListDTO productListDTO = Injector.deserialize(new ProductListDTO(), ConnectionManager.Method.POST, "searchProduct");
            Assertions.assertEquals(400, productListDTO.getResponseCode());
            Assertions.assertEquals("Bad request, search_product parameter is missing in POST request.", productListDTO.getMessage());
        }

        @Test
        @DisplayName("Check a POST request to searchProduct endpoint with a search_product parameter returns 200 OK")
        void testPostRequestToSearchProductWithSearchParam() {
            Map<String, String> params = new HashMap<>();
            params.put("search_product", "top");
            ProductListDTO productListDTO = Injector.deserialize(new ProductListDTO(), ConnectionManager.Method.POST, params, "searchProduct");
            Assertions.assertEquals(200, productListDTO.getResponseCode());
            assertTrue(productListDTO.getProducts().size() > 0, "Expected more than 0 products in the search results");
        }
    }


}
