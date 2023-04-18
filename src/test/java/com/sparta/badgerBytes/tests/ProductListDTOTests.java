package com.sparta.badgerBytes.tests;

import com.sparta.badgerBytes.testFramework.controll.ConnectionManager;
import com.sparta.badgerBytes.testFramework.model.Injector;
import org.junit.jupiter.api.*;
import com.sparta.badgerBytes.testFramework.model.dto.ProductListDTO;

import java.util.HashMap;
import java.util.Map;

public class ProductListDTOTests {

    private static String accessMethod;

    private static String urlEndpoint;

    private static String urlQueryParams;

    private static ProductListDTO productListDTOPost= new ProductListDTO();




    @BeforeAll
    static void setupPOST(){

        urlEndpoint="productsList";
        Map<String, String> products = new HashMap<>(Map.of("id","1")) ;
        productListDTOPost = Injector.deserialize(productListDTOPost, ConnectionManager.Method.POST, products,urlEndpoint);
    }

    @Nested
    @Order(1)
    @DisplayName("POST method tests")
    class PostMethod {

        @Test
        @Order(1)
        @DisplayName("1. Test POST method body response code")
        void testPostMethodBodyResponseCode() {
            Assertions.assertEquals(405,productListDTOPost.getResponseCodes());
        }

        @Test
        @Order(2)
        @DisplayName("2. Test POST body response message")
        void testPostBodyResponseMessage() {
            Assertions.assertEquals("This request method is not supported.",productListDTOPost.getMessage());
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
            Assertions.assertEquals(0,productListDTOPost.getNumProducts());
        }

        @Test
        @Order(5)
        @DisplayName("5. Test number of search results for POST method")
        void testNumberOfSearchResultsForPostMethod() {
            Assertions.assertEquals(0,productListDTOPost.getNumSearchResults());
        }

        @Test
        @Order(6)
        @DisplayName("6. Test search result for POST method")
        void testSearchResultForPostMethod() {
            Assertions.assertNull(productListDTOPost.getSearchResults());
        }

    }

}
