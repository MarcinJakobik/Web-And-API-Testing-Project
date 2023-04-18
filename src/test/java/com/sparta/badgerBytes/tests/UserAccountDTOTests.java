package com.sparta.badgerBytes.tests;

import com.sparta.badgerBytes.testFramework.controll.ConnectionManager.Method;
import com.sparta.badgerBytes.testFramework.model.Injector;
import com.sparta.badgerBytes.testFramework.model.dto.UserAccountDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class UserAccountDTOTests {
    String createAccountEndpoint = "createAccount";

    String updateAccountEndpoint = "updateAccount";

    UserAccountDTO userAccountDTO = new UserAccountDTO();
    
    Map<String, String> userData;
    
    @Test
    @DisplayName("Test POST to createAccount endpoint with valid fields, response body should have responseCode 201 and message 'User created!'")
    void testPostToCreateAccountWithValidData() {

        Map emailParam = new HashMap(Map.of("email", "ExampleEmail@example.com"));
        userAccountDTO = Injector.deserialize(userAccountDTO, Method.GET, emailParam, "getUserDetailByEmail");

        Map<String, String> param = new HashMap<>();
        param.put("email", "ExampleEmail@example.com");
        param.put("password", "ExamplePassword");

        if (userAccountDTO.getResponseCode() == 200) {
            userAccountDTO = Injector.deserialize(userAccountDTO, Method.DELETE, param, "deleteAccount");
        }

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

        userAccountDTO = Injector.deserialize(userAccountDTO, Method.POST, userData, createAccountEndpoint);
        Assertions.assertEquals(201, userAccountDTO.getResponseCode());
        Assertions.assertEquals("User created!", userAccountDTO.getMessage());
    }

    @Test
    @DisplayName("Test PUT to updateAccount endpoint with valid data - responseCode should be 200 and message 'User updated!'")
    void testPutToUpdateAccountWithValidData() {

        userData = new HashMap<>();
        userData.put("email", "ExampleEmail@example.com");
        userData.put("password", "ExamplePassword");
        userData.put("name", "Name");
        userData.put("title", "Mr");
        userData.put("birth_date", "10");
        userData.put("birth_month", "April");
        userData.put("birth_year", "1990");
        userData.put("firstname", "William");
        userData.put("lastname", "Bailey");
        userData.put("company", "Sparta Global");
        userData.put("email", "billbailey@gmail.com");
        userData.put("country", "ExamplePassword");
        userData.put("zipcode", "ExamplePassword");
        userData.put("state", "ExamplePassword");
        userData.put("city", "ExamplePassword");
        userData.put("mobile_number", "+447777777777");
        userData.put("address1", "ExamplePassword");

        userAccountDTO = Injector.deserialize(userAccountDTO, Method.PUT, userData, updateAccountEndpoint);
        Assertions.assertEquals(200, userAccountDTO.getResponseCode());
        Assertions.assertEquals("User updated!", userAccountDTO.getMessage());
    }

}
