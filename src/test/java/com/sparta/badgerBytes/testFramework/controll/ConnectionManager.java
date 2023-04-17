package com.sparta.badgerBytes.testFramework.controll;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ConnectionManager {
    private static final String BASE_URL = "https://automationexercise.com/";
    private static String resource = "api/";
    private static String endpoint = "";
    private static Method method;
    private static Map<String, String> params = new HashMap<>();
    public enum Method{
        GET("GET"),
        PUT("PUT"),
        POST("POST"),
        PATCH("PATCH"),
        DELETE("DELETE");
        private String status;
        private Method(String s){
            status = s;
        }
        public String toString(){
            return status;
        }
    }

    private ConnectionManager(){}
    public static void setEndpoint(String setEndpoint){
        endpoint = setEndpoint;
    }

    public static void setResource(String setResource){
        resource = setResource;
    }

    public static void addProperty(String key, String value){
        params.put(key, value);
    }

    public static void removeAllProperties(){
        params.clear();
    }
    public static void setMethod(Method setMethod){
        method = setMethod;
    }

    public static void setAllProperties(Map<String, String> setParams){
        params = setParams;
    }

    public static HttpResponse getResponse(Method setMethod, String setEndpoint){
        method = setMethod;
        endpoint = setEndpoint;
        return getResponse();
    }
    public static HttpResponse getResponse(Method setMethod, Map setParams, String setEndPoint){
        params = setParams;
        return getResponse(setMethod, setEndPoint);
    }

    public static HttpResponse getResponse(){
        if(method == null) return null;
        if(endpoint == null || endpoint.length() == 0) return null;
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest.Builder builder = HttpRequest.newBuilder();
        builder = builder.header("Accept", "application/json");

        switch(method){
            case GET:
                String queryParams = getQueryParams();
                builder = builder.uri(URI.create(BASE_URL + resource + endpoint + queryParams));
                builder = builder.GET();
                break;
            case PUT:
            case PATCH:
            case DELETE:
            case POST:
                String requestBody = getRequestBody();
                builder = builder.uri(URI.create(BASE_URL + resource + endpoint));
                if(requestBody != null && requestBody.length() > 0){
                    builder = builder.header("content-type", "application/x-www-form-urlencoded");
                    builder = builder.method(method.toString(), HttpRequest.BodyPublishers.ofString(requestBody));
                }else{
                    builder = builder.method(method.toString(), HttpRequest.BodyPublishers.noBody());
                }
        }

        HttpRequest request = builder.build();
        try {
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            removeAllProperties();
            endpoint = "";
            method = null; /*Resets to default state after getting the response*/
            return response;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String getRequestBody() {
        return getQueryParams().substring(1);
    }

    private static String getQueryParams() {
        String queryParams = "?";
        Set<String> keys = params.keySet();
        for(String key : keys){
            queryParams += key + "=" + URLEncoder.encode(params.get(key)) + "&";
        }
        int positionToRemove = queryParams.lastIndexOf("&");
        if(positionToRemove == -1)
            return queryParams;
        return queryParams.substring(0, positionToRemove);
    }
}
