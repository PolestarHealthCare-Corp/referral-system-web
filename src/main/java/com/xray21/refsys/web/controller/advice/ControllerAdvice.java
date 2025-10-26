package com.xray21.refsys.web.controller.advice;

import com.xray21.refsys.web.dto.ErrorResponse;
import com.xray21.refsys.web.dto.Response;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.xray21.refsys.web.controller.api")
@Slf4j
public class ControllerAdvice {

	// IllegalArgumentException
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Response> handleIllegalArgument(IllegalArgumentException e) {
		log.error("[ExceptionHandler] IllegalArgumentException", e);
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(Response.error(ErrorResponse.from(e)));
	}

	// IllegalStateException
	@ExceptionHandler(IllegalStateException.class)
	public ResponseEntity<Response> handleIllegalState(IllegalStateException e) {
		log.error("[ExceptionHandler] IllegalStateException", e);
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(Response.error(ErrorResponse.from(e)));
	}

	// NullPointerException
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Response> handleNullPointer(NullPointerException e) {
		log.error("[ExceptionHandler] NullPointerException", e);
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(Response.error(ErrorResponse.from(e)));
	}

	// DB 예외
	@ExceptionHandler(DataAccessException.class)
	public ResponseEntity<Response<?>> handleDataAccess(DataAccessException e) {
		log.error("[ExceptionHandler] DataAccessException", e);
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(Response.error(ErrorResponse.from(e)));
	}

	// SQL 예외 (JDBC)
	@ExceptionHandler(java.sql.SQLException.class)
	public ResponseEntity<Response> handleSQLException(java.sql.SQLException e) {
		log.error("[ExceptionHandler] SQLException", e);
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(Response.error(ErrorResponse.from(e)));
	}

	// 모든 Exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response> handleException(Exception e, HttpServletRequest request) {
		if(request.getRequestURI().startsWith("/.well-known/")) {
			log.debug("Ignored NoResourceFound for: " + request.getRequestURI());
			return ResponseEntity.notFound().build();
		}
		log.error("[ExceptionHandler] Exception", e);
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(Response.error(ErrorResponse.from(e)));
	}

}