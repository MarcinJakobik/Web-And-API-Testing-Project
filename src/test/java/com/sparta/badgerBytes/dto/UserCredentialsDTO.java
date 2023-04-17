package com.sparta.badgerBytes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserCredentialsDTO {

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
