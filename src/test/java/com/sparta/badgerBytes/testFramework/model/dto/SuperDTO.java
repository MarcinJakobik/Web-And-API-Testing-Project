package com.sparta.badgerBytes.testFramework.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SuperDTO {

    @JsonProperty("responseCode")
    private String responseCode;

    @JsonProperty("message")
    private String message;
}
