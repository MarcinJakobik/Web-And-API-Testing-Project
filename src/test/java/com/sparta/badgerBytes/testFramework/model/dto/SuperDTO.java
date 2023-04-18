package com.sparta.badgerBytes.testFramework.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SuperDTO {

    @JsonProperty("responseCode")
    private int responseCode;

    @JsonProperty("message")
    private String message;

    public int getResponseCodes() {
        return responseCode;
    }

    public String getMessage() {
        return message;
    }
}
