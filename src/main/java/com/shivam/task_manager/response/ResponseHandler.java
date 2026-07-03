package com.shivam.task_manager.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public class ResponseHandler {
    public static ResponseEntity<Object> handleResponse(HttpStatus httpStatus, String message, Object data) {
        HashMap<String, Object> responseMap = new HashMap<>();
        responseMap.put("http status", httpStatus );
        responseMap.put("message", message);
        responseMap.put("data", data);

        return new ResponseEntity<>(responseMap, httpStatus);
    }
}
