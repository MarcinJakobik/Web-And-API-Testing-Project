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

    String urlResource;
    String urlQueryParams;
    private static String urlEndpoint = "brandsList";

    private static HttpResponse response;
    private static HttpResponse getResponse;
    private static HttpResponse putResponse;

    private static BrandsListDTO brandsListDTO = new BrandsListDTO();
    private static BrandsListDTO getBrandsListDTO = new BrandsListDTO();
    private static BrandsListDTO putBrandsListDTO = new BrandsListDTO();

    @BeforeAll
    static void setup(){
        getResponse = ConnectionManager.getResponse(Method.GET, urlEndpoint);
        putResponse = ConnectionManager.getResponse(Method.PUT, urlEndpoint);
        getBrandsListDTO = Injector.deserialize(brandsListDTO, ConnectionManager.Method.GET, urlEndpoint);
        putBrandsListDTO = Injector.deserialize(brandsListDTO, ConnectionManager.Method.PUT, urlEndpoint);
    }

    @Nested
    @DisplayName("Header Checks For BrandsList Endpoint API Response Using Get Request")
    class HeaderChecksForBrandsListEndpointApiResponseUsingGetRequest {

        @Test
        @DisplayName("Check status code response when using a Get request on the brandsList endpoint")
        void checkStatusCodeResponseUsingGetOnBrandsListAPI() {
            assertEquals(200, getResponse.statusCode(), "Status code should return a 200 error code");
        }

        @Test
        @DisplayName("Check that the server header is cloudflare")
        void checkThatTheServerHeaderIsCloudflare() {
            assertEquals("cloudflare", getBrandsListDTO.getHeaderPropertyAsString("server"));
        }
    }

    @Nested
    @DisplayName("Body Checks For Get Request On BrandsList API")
    class BodyChecksForGetRequestOnBrandsListApi {
        @Test
        @DisplayName(" Checks if response code is 200 and BrandsList is not null")
        void testGetAllBrandsList() {
            assertNotNull(getBrandsListDTO.getBrands(), "Brand list should not be null");
            assertEquals(200, getBrandsListDTO.getResponseCode(), "Response code should be 200");
        }

        @Test
        @DisplayName("Check brandsList has at least one brand")
        void checkBrandsListHasAtLeastOneBrand() {
            assertNotNull(getBrandsListDTO.getBrands(), "Brand list should not be null");
        }

        @Test
        @DisplayName("Check brandsList has the expected amount of brands")
        void checkBrandsListHasTheExpectedAmountOfBrands() {
            assertEquals(34, getBrandsListDTO.numberOfBrands(), "There should be 34 brands");
        }

        @Test
        @DisplayName("Check that brands are not listed more than once")
        void checkThatBrandsAreNotListedMoreThanOnce() {
            assertTrue(getBrandsListDTO.checkBrandDuplication(), "There is 1 or more brand duplications");
        }

        @Test
        @DisplayName("Check that ids are sequential")
        void checkThatIdsAreSequential() {
            assertTrue(getBrandsListDTO.checkForNonSequentialIds(), "There are 1 or more id numbers that are missing");
        }

        @Test
        @DisplayName("Check that ids are not duplicated")
        void checkThatIdsAreNotDuplicated() {
            assertTrue(getBrandsListDTO.checkForDuplicatedIds(), "There is 1 or more id duplications");
        }
    }
    @Nested
    @DisplayName("Header Checks For BrandsList Endpoint API Responses Using Put Request")
    class HeaderChecksForBrandsListEndpointApiResponsesUsingPutRequest {

        @Test
        @DisplayName("Check status code response when using a PUT request on the brandsList endpoint")
        void checkStatusCodeResponseUsingPutOnBrandsListAPI() {
            assertEquals(405, getResponse.statusCode(), "Status code should return a 405 error code");
        }

        @Test
        @DisplayName("Check that the server header is cloudflare")
        void checkThatTheServerHeaderIsCloudflare() {
            assertEquals("cloudflare", putBrandsListDTO.getHeaderPropertyAsString("server"));
        }
    }

    @Nested
    @DisplayName("Check Body Responses For Put Request On The BrandsList API")
    class CheckBodyResponsesForPutRequestOnTheBrandsListApi {
        @Test
        @DisplayName("Check response message when using a PUT request on the brandsList endpoint")
        void checkResponseMessageResponseUsingPutOnBrandsListAPI() {
            assertEquals(405, putBrandsListDTO.getResponseCode(),"Response code should be 405");
            assertEquals("This request method is not supported.", putBrandsListDTO.getMessage(),
                    "The expected response message is: This request method is not supported.");
        }

        @Test
        @DisplayName("Check that there is no body content returned in PUT request on the brandsList endpoint other than response code and message")
        void checkOnlyResponseCodeAndMessageReturnedForPutRequestOnBrandsListAPI() {
            assertNull(putBrandsListDTO.getBrands(), "There should be no brands in this response");
        }
    }
}
