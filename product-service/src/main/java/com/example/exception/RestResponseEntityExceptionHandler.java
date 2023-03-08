/**
 * 
 */
package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.error.ErrorResponse;

/**
 * @author Rama Krishna M
 *
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ProductServiceCustomException.class)
	public ResponseEntity<ErrorResponse> handleProductServiceException(ProductServiceCustomException exception) {

		ErrorResponse response = new ErrorResponse();
		response.setErrorMessage(exception.getMessage());

		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
