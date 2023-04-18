package com.sparta.badgerBytes.tests;

import com.sparta.badgerBytes.testFramework.controll.ConnectionManager.Method;
import com.sparta.badgerBytes.testFramework.model.Injector;
import com.sparta.badgerBytes.testFramework.model.dto.UserCredentialsDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class UserCredentialsDTOTests {

    private static String urlEndpoint = "/verifyLogin";

    private static UserCredentialsDTO userCredentialsDTO;
    
    @Test
    @DisplayName("Check a POST request to verifyLogin endpoint with invalid credentials gets body property 'responseCode' 404 & 'message' user not found")
    void testPostInvalidCredentialsToVerifyLogin() {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("email", "");
        requestBody.put("password", "");
        userCredentialsDTO = Injector.deserialize(userCredentialsDTO, Method.POST, requestBody, urlEndpoint);
        Assertions.assertEquals(404, userCredentialsDTO.getResponseCodes());
        Assertions.assertEquals("User not found!", userCredentialsDTO.getMessage());
    }

    
}
