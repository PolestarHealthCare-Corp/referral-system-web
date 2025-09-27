package com.xray21.refsys.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Response<T> {
    private String resultCode;
    private T result;

    public static <T> Response<T> success(T result) {
        return new Response("SUCCESS", result);
    }

    public static Response<ErrorResponse> error(ErrorResponse errorResponse){
        return new Response<>("ERROR", errorResponse);
    }
}
