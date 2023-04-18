package com.sparta.badgerBytes.testFramework.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class SuperDTO {
    @JsonProperty("responseCode")
    private Integer responseCode;

    @JsonProperty("message")
    private String message;

    private Integer statusCode;

    private Map<String, List<String>> headerProperties;

    public void setResponseCode(Integer responseCode){
        this.responseCode = responseCode;
    }

    public void setStatusCode(Integer statusCode){
        this.statusCode = statusCode;
    }

    public void setHeaderProperties(Map<String, List<String>> headerProperties){
        this.headerProperties = headerProperties;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public String getMessage() {
        return message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public Map<String, List<String>> getHeaderProperties() {
        return headerProperties;
    }
}
