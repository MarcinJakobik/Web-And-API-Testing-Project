package com.sparta.badgerBytes.tests;

import com.sparta.badgerBytes.testFramework.controll.ConnectionManager;
import com.sparta.badgerBytes.testFramework.controll.ConnectionManager.Method;
import com.sparta.badgerBytes.testFramework.model.Injector;
import com.sparta.badgerBytes.testFramework.model.dto.UserAccountDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class UserAccountDTOTests {
    String urlEndpoint = "/createAccount";

    UserAccountDTO userAccountDTO = new UserAccountDTO();
    
    Map<String, String> userData;
    
    @Test
    @DisplayName("Test POST to createAccount endpoint with valid fields, response body should have responseCode 201 and message 'User created!'")
    void testPostToCreateAccountWithValidData() {

        userData = new HashMap<>();
        userData.put("email", "ExampleEmail@example.com");
        userData.put("password", "ExamplePassword");
        userData.put("name", "Name");
        userData.put("title", "Mr");
        userData.put("birth_date", "10");
        userData.put("birth_month", "April");
        userData.put("birth_year", "1990");
        userData.put("firstname", "Firstname");
        userData.put("lastname", "Lastname");
        userData.put("company", "Company");
        userData.put("email", "ExampleEmail@example.com");
        userData.put("country", "ExamplePassword");
        userData.put("zipcode", "ExamplePassword");
        userData.put("state", "ExamplePassword");
        userData.put("city", "ExamplePassword");
        userData.put("mobile_number", "+447777777777");
        userData.put("address1", "ExamplePassword");

        userAccountDTO = Injector.deserialize(userAccountDTO, Method.POST, userData, urlEndpoint);
        Assertions.assertEquals(201, userAccountDTO.getResponseCodes());
        Assertions.assertEquals("User created!", userAccountDTO.getMessage());
    }



}
