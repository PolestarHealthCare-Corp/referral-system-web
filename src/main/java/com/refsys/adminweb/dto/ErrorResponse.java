package com.refsys.adminweb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    public String exceptionName;
    public String message;

    public static ErrorResponse from(Exception e) {
        return new ErrorResponse(e.getClass().getSimpleName(), e.getMessage());
    }
}