package com.sparta.badgerBytes.tests;

import com.sparta.badgerBytes.testFramework.controll.ConnectionManager.Method;
import com.sparta.badgerBytes.testFramework.model.Injector;
import com.sparta.badgerBytes.testFramework.model.dto.UserCredentialsDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class UserCredentialsDTOTests {

    private static String urlEndpoint = "/verifyLogin";

    private static UserCredentialsDTO userCredentialsDTO = new UserCredentialsDTO();
    
    @Test
    @DisplayName("Check a POST request to verifyLogin endpoint with invalid credentials gets body property 'responseCode' 404 & 'message' user not found")
    void testPostInvalidCredentialsToVerifyLogin() {
        Map<String, String> requestBody = new HashMap<>(Map.of("email","", "password",""));
        userCredentialsDTO = Injector.deserialize(userCredentialsDTO, Method.POST, requestBody, urlEndpoint);
        Assertions.assertEquals(404, userCredentialsDTO.getResponseCode());
        Assertions.assertEquals("User not found!", userCredentialsDTO.getMessage());
    }

    @Test
    @DisplayName("POST To verify login without email parameters")
    void postToVerifyLoginWithoutEmailParameters()
    {
        //parameters
        Map<String,String> param = new HashMap<>(Map.of("password","myPassword"));
        userCredentialsDTO = Injector.deserialize(userCredentialsDTO, Method.POST, param,urlEndpoint);



        //Checks
        Assertions.assertEquals(400,userCredentialsDTO.getResponseCode());
        Assertions.assertEquals("Bad request, email or password parameter is missing in POST request.", userCredentialsDTO.getMessage());
    }

    @Test
    @DisplayName("Post to verify login without any parameters")
    void postToVerifyLoginWithoutAnyParameters()
    {

        userCredentialsDTO = Injector.deserialize(userCredentialsDTO, Method.POST, urlEndpoint);

        Assertions.assertEquals(400, userCredentialsDTO.getResponseCode());
        Assertions.assertEquals("Bad request, email or password parameter is missing in POST request.", userCredentialsDTO.getMessage());
    }

    @Test
    @DisplayName("Get to verify login")
    void getToVerifyLogin()
    {
        userCredentialsDTO = Injector.deserialize(userCredentialsDTO, Method.GET, urlEndpoint);

        Assertions.assertEquals(405, userCredentialsDTO.getResponseCode());
        Assertions.assertEquals("This request method is not supported.", userCredentialsDTO.getMessage());
    }

    @Test
    @DisplayName("PUT to verify login")
    void putToVerifyLogin()
    {
        userCredentialsDTO = Injector.deserialize(userCredentialsDTO, Method.PUT, urlEndpoint);

        Assertions.assertEquals(405,userCredentialsDTO.getResponseCode());
        Assertions.assertEquals("This request method is not supported.", userCredentialsDTO.getMessage());
    }

    @Test
    @DisplayName("Post to verify login with invalid parameters")
    void postToVerifyLoginWithInvalidParameters()
    {
        //parameters
        Map<String,String> param = new HashMap<>(Map.of("UserDetails","EmailAdress"));

        userCredentialsDTO = Injector.deserialize(userCredentialsDTO, Method.POST, param, urlEndpoint);

        //Checks
        Assertions.assertEquals(400, userCredentialsDTO.getResponseCode());
        Assertions.assertEquals("Bad request, email or password parameter is missing in POST request.", userCredentialsDTO.getMessage());
    }


    //Delete request
    @Nested
    class DeleteAccount {

        @Test
        @DisplayName("Delete to Delete account and delete users account")
        void deleteToDeleteAccountAndDeleteUsersAccount() {

            //create User
            Map<String, String> userParam = new HashMap<>();
            userParam.put("email", "ExampleEmail@example.com");
            userParam.put("password", "ExamplePassword");
            userParam.put("name", "ExampleEmail@example.com");
            userParam.put("title", "Mr");
            userParam.put("birth_data", "ExampleEmail@example.com");
            userParam.put("birth_month", "ExamplePassword");
            userParam.put("birth_year", "ExampleEmail@example.com");
            userParam.put("firstname", "ExamplePassword");
            userParam.put("lastname", "ExampleEmail@example.com");
            userParam.put("company", "ExamplePassword");
            userParam.put("email", "ExampleEmail@example.com");
            userParam.put("country", "ExamplePassword");
            userParam.put("zipcode", "ExamplePassword");
            userParam.put("state", "ExamplePassword");
            userParam.put("city", "ExamplePassword");
            userParam.put("mobile_number", "ExamplePassword");
            userParam.put("address1", "ExamplePassword");


            //Create account
            String urlTest = "createAccount";
            userCredentialsDTO = Injector.deserialize(userCredentialsDTO, Method.POST, userParam, urlTest);
            Assertions.assertEquals(201, userCredentialsDTO.getResponseCode());


            //create parameters to delete user
            Map<String, String> param = new HashMap<>();
            param.put("email", "ExampleEmail@example.com");
            param.put("password", "ExamplePassword");


            urlTest = "deleteAccount";

            userCredentialsDTO = Injector.deserialize(userCredentialsDTO, Method.DELETE, param, urlTest);

            //Checks
            Assertions.assertEquals(200, userCredentialsDTO.getResponseCode());
            Assertions.assertEquals("Account deleted!", userCredentialsDTO.getMessage());

        }

        @Test
        @DisplayName("Post to Delete account api without email")
        void getToDeleteAccountApi()
        {
            String urlTest = "deleteAccount";

            userCredentialsDTO = Injector.deserialize(userCredentialsDTO, Method.DELETE, urlTest);

            //Checks
            Assertions.assertEquals(400, userCredentialsDTO.getResponseCode());
            Assertions.assertEquals("Bad request, email parameter is missing in DELETE request.", userCredentialsDTO.getMessage());
        }

    }
}
