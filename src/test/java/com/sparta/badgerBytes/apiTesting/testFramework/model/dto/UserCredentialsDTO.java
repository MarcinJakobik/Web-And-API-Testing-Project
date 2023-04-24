package com.sparta.badgerBytes.apiTesting.testFramework.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserCredentialsDTO extends SuperDTO{

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
