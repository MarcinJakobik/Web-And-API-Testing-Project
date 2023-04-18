package com.sparta.badgerBytes.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.badgerBytes.testFramework.controll.ConnectionManager;
import com.sparta.badgerBytes.testFramework.model.dto.UserAccountDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpResponse;

import com.sparta.badgerBytes.testFramework.controll.ConnectionManager.Method;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserAccountDTOTests {

    static String deleteURLEndpoint;

    @BeforeAll
    static void setup() {
        deleteURLEndpoint = "verifyLogin";
    }

    @Test
    void testDeleteRequest() throws IOException {
        HttpResponse deleteResponse = ConnectionManager.getResponse(Method.DELETE, deleteURLEndpoint);
        assertEquals("{\"responseCode\": 405, \"message\": \"This request method is not supported.\"}", deleteResponse.body().toString());


    }
}
