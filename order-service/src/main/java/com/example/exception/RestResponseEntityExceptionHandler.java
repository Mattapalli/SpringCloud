/**
 * 
 */
package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Rama Krishna M
 *
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(OrderServiceCustomException.class)
	public ResponseEntity<ErrorResponse> handleCustomException(OrderServiceCustomException exception) {
		ErrorResponse respone = new ErrorResponse();
		respone.setErrorMessage(exception.getMessage());
		respone.setErrorCode(exception.getErrorCode());
		return new ResponseEntity<>(respone, HttpStatus.valueOf(exception.getStatus()));
	}
}
