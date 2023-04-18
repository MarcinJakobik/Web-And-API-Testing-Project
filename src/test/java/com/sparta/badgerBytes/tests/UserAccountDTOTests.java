package com.sparta.badgerBytes.tests;

import com.sparta.badgerBytes.testFramework.controll.ConnectionManager;
import com.sparta.badgerBytes.testFramework.controll.ConnectionManager.Method;
import com.sparta.badgerBytes.testFramework.model.Injector;
import com.sparta.badgerBytes.testFramework.model.dto.ProductListDTO;
import com.sparta.badgerBytes.testFramework.model.dto.UserAccountDTO;
import com.sparta.badgerBytes.testFramework.model.dto.UserCredentialsDTO;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

public class UserAccountDTOTests {
    String createAccountEndpoint = "createAccount";

    String updateAccountEndpoint = "updateAccount";

    UserAccountDTO userAccountDTO = new UserAccountDTO();

    Map<String, String> userData;

    @Test
    @Order(1)
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
        userData.put("password", "ExamplePassword");
        userData.put("name", "Name");
        userData.put("title", "Mr");
        userData.put("birth_date", "ExampleEmail@example.com");
        userData.put("birth_month", "ExamplePassword");
        userData.put("birth_year", "ExampleEmail@example.com");
        userData.put("firstname", "ExamplePassword");
        userData.put("lastname", "ExampleEmail@example.com");
        userData.put("company", "ExamplePassword");
        userData.put("email", "ExampleEmail@example.com");
        userData.put("country", "ExamplePassword");
        userData.put("zipcode", "ExamplePassword");
        userData.put("state", "ExamplePassword");
        userData.put("city", "ExamplePassword");
        userData.put("mobile_number", "ExamplePassword");
        userData.put("address1", "ExamplePassword");

        userAccountDTO = Injector.deserialize(userAccountDTO, Method.POST, userData, createAccountEndpoint);
        Assertions.assertEquals(201, userAccountDTO.getResponseCode());
        Assertions.assertEquals("User created!", userAccountDTO.getMessage());
    }

    @Test
    @Order(2)
    @DisplayName("Test retrieving user data")
    void testRetrievingUserData() {

        Map<String, String> params = new HashMap<>(Map.of("email", "ExampleEmail@example.com"));
        UserAccountDTO userCredentials = Injector.deserialize(new UserAccountDTO(), Method.GET, params, "getUserDetailByEmail");
        UserAccountDTO.User usr = userCredentials.getUser();
        Assertions.assertEquals(200, userCredentials.getResponseCode());
        Assertions.assertEquals("Name", usr.getName());
        Assertions.assertEquals("ExampleEmail@example.com", usr.getEmail());
        Assertions.assertEquals("Mr", usr.getTitle());
        Assertions.assertEquals("10", usr.getBirthDay());
        Assertions.assertEquals("April", usr.getBirthMonth());
        Assertions.assertEquals("1990", usr.getBirthYear());
        Assertions.assertEquals("Firstname", usr.getFirstName());
        Assertions.assertEquals("Lastname", usr.getLastName());
        Assertions.assertEquals("Company", usr.getCompany());
        Assertions.assertEquals("ExamplePassword", usr.getAddress1());
        Assertions.assertEquals("", usr.getAddress2());
        Assertions.assertEquals("ExamplePassword", usr.getState());
        Assertions.assertEquals("ExamplePassword", usr.getCity());
        Assertions.assertEquals("ExamplePassword", usr.getZipcode());
    }

    @Test
    @Order(3)
    @DisplayName("Test PUT to updateAccount endpoint with valid data - responseCode should be 200 and message 'User updated!'")
    void testPutToUpdateAccountWithValidData() {

        userData = new HashMap<>();
        userData.put("password", "ExamplePassword");
        userData.put("name", "Name");
        userData.put("title", "Mr");
        userData.put("birth_date", "ExampleEmail@example.com");
        userData.put("birth_month", "ExamplePassword");
        userData.put("birth_year", "ExampleEmail@example.com");
        userData.put("firstname", "ExamplePassword");
        userData.put("lastname", "ExampleEmail@example.com");
        userData.put("company", "ExamplePassword");
        userData.put("email", "ExampleEmail@example.com");
        userData.put("country", "ExamplePassword");
        userData.put("zipcode", "ExamplePassword");
        userData.put("state", "ExamplePassword");
        userData.put("city", "ExamplePassword");
        userData.put("mobile_number", "ExamplePassword");
        userData.put("address1", "ExamplePassword");

        userAccountDTO = Injector.deserialize(userAccountDTO, Method.PUT, userData, updateAccountEndpoint);
        Assertions.assertEquals(200, userAccountDTO.getResponseCode());
        Assertions.assertEquals("User updated!", userAccountDTO.getMessage());
    }
}
