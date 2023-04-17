package com.sparta.badgerBytes.testFramework.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.badgerBytes.testFramework.controll.ConnectionManager;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class Injector {

    public static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T deserialize(T dto) {
        ConnectionManager.Method setMethod = null;
        Map setParams = null;
        String setEndPoint = null;
        return deserialize(dto, setMethod, setParams, setEndPoint);
    }

    public static <T> T deserialize(T dto, ConnectionManager.Method setMethod, String setEndPoint) {
        Map setParams = null;
        return deserialize(dto, setMethod, setParams, setEndPoint);
    }

    public static <T> T deserialize(T dto, ConnectionManager.Method setMethod, Map setParams, String setEndPoint) {

        String jsonBody;
        try {
            if (setParams == null) {
                jsonBody = ConnectionManager.getResponse(setMethod, setEndPoint).body().toString();
            } else {
                jsonBody = ConnectionManager.getResponse(setMethod, setParams, setEndPoint).body().toString();
            }
            dto = (T) dto.getClass().newInstance();
            dto = (T) objectMapper.readValue(jsonBody, dto.getClass());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return dto;
    }

    public static <T> String serialize(T dto) {

        String jsonBody = "";

        try {
            jsonBody = objectMapper.writeValueAsString(dto);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonBody;
    }

    public static String serialize(Map<String, Object> map) {

        StringBuilder jsonBodyBuilder = new StringBuilder();
        jsonBodyBuilder.append("{");
        Set<String> keySet = map.keySet();

        for (String key : keySet) {
            Object value = map.get(key);
            jsonBodyBuilder.append("\"").append(key).append("\":");
            if (value instanceof String) {
                jsonBodyBuilder.append("\"").append(value).append("\",");
            } else if (value instanceof Number) {
                jsonBodyBuilder.append(value).append(",");
            } else if (value instanceof Boolean) {
                jsonBodyBuilder.append(value).append(",");
            } else if (value instanceof Object[]) {
                Object[] arrOfObjects = (Object[]) value;
                jsonBodyBuilder.append("[");
                for (int i = 0; i < arrOfObjects.length; i++) {
                    Object innerObj = arrOfObjects[i];
                    if (innerObj instanceof String) {
                        jsonBodyBuilder.append("\"").append(innerObj).append("\",");
                    } else {
                        jsonBodyBuilder.append(innerObj.toString()).append(",");
                    }
                }
                jsonBodyBuilder.deleteCharAt(jsonBodyBuilder.length() - 1).append("],");
            } else if (value == null) {
                jsonBodyBuilder.append("null,");
            } else if (value instanceof Map) {
                jsonBodyBuilder.append(serialize((Map<String, Object>) value)).append(",");
            } else if (value instanceof ToJson) {
                jsonBodyBuilder.append(((ToJson) value).toJson()).append(",");
            } else {
                return null;
            }
        }
        jsonBodyBuilder.deleteCharAt(jsonBodyBuilder.length() - 1).append("}");
        return jsonBodyBuilder.toString();
    }
}