package com.sparta.badgerBytes.testFramework.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SuperDTO {

    @JsonProperty("responseCode")
    private Integer responseCode;

    @JsonProperty("message")
    private String message;

    public Integer getResponseCode() {
        return responseCode;
    }

    public String getMessage() {
        return message;
    }
}
