package com.xray21.refsys.web.controller.advice;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	// IllegalArgumentException
	@ExceptionHandler(IllegalArgumentException.class)
	public String handleIllegalArgument(IllegalArgumentException e) {
		log.error("[ExceptionHandler] IllegalArgumentException", e);
		return "errors/400";
	}

	// IllegalStateException
	@ExceptionHandler(IllegalStateException.class)
	public String handleIllegalState(IllegalStateException e) {
		log.error("[ExceptionHandler] IllegalStateException", e);
		return "errors/400";
	}

	// NullPointerException
	@ExceptionHandler(NullPointerException.class)
	public String handleNullPointer(NullPointerException e) {
		log.error("[ExceptionHandler] NullPointerException", e);
		return "errors/400";
	}

	// DB 예외
	@ExceptionHandler(DataAccessException.class)
	public String handleDataAccess(DataAccessException e) {
		log.error("[ExceptionHandler] DataAccessException", e);
		return "errors/500";
	}

	// SQL 예외 (JDBC)
	@ExceptionHandler(java.sql.SQLException.class)
	public String handleSQLException(java.sql.SQLException e) {
		log.error("[ExceptionHandler] SQLException", e);
		return "errors/500";
	}

	// RuntimeException
	@ExceptionHandler(RuntimeException.class)
	public String handleRuntimeException(RuntimeException e) {
		log.error("[ExceptionHandler] RuntimeException", e);
		return "errors/500";
	}

	// 모든 Exception
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e, HttpServletRequest request) {
		if(request.getRequestURI().startsWith("/.well-known/")) {
			log.debug("Ignored NoResourceFound for: " + request.getRequestURI());
			return "errors/500";
		}
		log.error("[ExceptionHandler] Exception", e);
		return "errors/500";
	}

}