package com.sparta.badgerBytes.tests;

import com.sparta.badgerBytes.testFramework.controll.ConnectionManager.Method;
import com.sparta.badgerBytes.testFramework.controll.ConnectionManager;
import com.sparta.badgerBytes.testFramework.model.Injector;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import com.sparta.badgerBytes.testFramework.model.dto.BrandsListDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.net.http.HttpResponse;
import java.util.List;

public class BrandsListDTOTests {

    String urlResource = "/api/brandsList" ;

    String urlQueryParams;

    private static String urlEndpoint = "brandsList";

    private static HttpResponse response;

    BrandsListDTO brandsListDTO = new BrandsListDTO();

    @BeforeAll
    static void setup(){

    }
    @Nested
    @DisplayName("Header Checks For BrandsList Endpoint API Response Using Get Request")
    class HeaderChecksForBrandsListEndpointApiResponseUsingGetRequest {
        @Test
        @DisplayName("Check status code response when using a Get request on the brandsList endpoint")
        void checkStatusCodeResponseUsingGetOnBrandsListAPI() {
            //Arrange
            response = ConnectionManager.getResponse(Method.GET, urlEndpoint);
            //Act
            //Assert
            assertEquals(200, response.statusCode(), "Status code should return a 200 error code");
        }
    }
    @Nested
    @DisplayName("Body Checks For Get Request On BrandsList API")
    class BodyChecksForGetRequestOnBrandsListApi {
        @Test
        @DisplayName(" Checks if response code is 200 and BrandsList is not null")
        void testGetAllBrandsList() {
            //Arrange
            brandsListDTO = Injector.deserialize(brandsListDTO, ConnectionManager.Method.GET, urlEndpoint);
            //Act
            //Assert
            assertNotNull(brandsListDTO.getBrands(), "Brand list should not be null");
            assertEquals(200, brandsListDTO.getResponseCode(), "Response code should be 200");
        }

        @Test
        @DisplayName("Check brandsList has at least one brand")
        void checkBrandsListHasAtLeastOneBrand() {
            //Arrange
            brandsListDTO = Injector.deserialize(brandsListDTO, ConnectionManager.Method.GET, urlEndpoint);
            //Act
            //Assert
            assertNotNull(brandsListDTO.getBrands(), "Brand list should not be null");
        }
    }
    @Nested
    @DisplayName("Header Checks For BrandsList Endpoint API Responses Using Put Request")
    class HeaderChecksForBrandsListEndpointApiResponsesUsingPutRequest {

        @Test
        @DisplayName("Check status code response when using a PUT request on the brandsList endpoint")
        void checkStatusCodeResponseUsingPutOnBrandsListAPI() {
            //Arrange
            response = ConnectionManager.getResponse(Method.PUT, urlEndpoint);
            //Act
            //Assert
            assertEquals(405, response.statusCode(), "Status code should return a 405 error code");
        }
    }
    @Nested
    @DisplayName("Check Body Responses For Put Request On The BrandsList API")
    class CheckBodyResponsesForPutRequestOnTheBrandsListApi {
        @Test
        @DisplayName("Check response message when using a PUT request on the brandsList endpoint")
        void checkResponseMessageResponseUsingPutOnBrandsListAPI() {
            //Arrange
            brandsListDTO = Injector.deserialize(brandsListDTO, Method.PUT, urlEndpoint);
            //Act
            //Assert
            assertEquals(405, brandsListDTO.getResponseCode(),"Response code should be 405");
            assertEquals("This request method is not supported.", brandsListDTO.getMessage(),
                    "The expected response message is: This request method is not supported.");
        }
        @Test
        @DisplayName("Check that there is no body content returned in PUT request on the brandsList endpoint other than response code and message")
        void checkOnlyResponseCodeAndMessageReturnedForPutRequestOnBrandsListAPI() {
            //Arrange
            brandsListDTO = Injector.deserialize(brandsListDTO, Method.PUT, urlEndpoint);
            //Act
            //Assert
            assertNull(brandsListDTO.getBrands(), "There should be no brands in this response");
        }
    }
}
