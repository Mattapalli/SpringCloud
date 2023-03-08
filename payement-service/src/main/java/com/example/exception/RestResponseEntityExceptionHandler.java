/**
 * 
 */
package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.model.ErrorResponse;

/**
 * @author Rama Krishna M
 *
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	 @ExceptionHandler(PaymentServiceCustomException.class)
	    public ResponseEntity<ErrorResponse> handleProductServiceException(PaymentServiceCustomException exception) {
		 ErrorResponse respone =new ErrorResponse();
		 respone.setErrorMessage(exception.getMessage());
		 respone.setErrorCode(HttpStatus.EXPECTATION_FAILED.toString());
		 return new ResponseEntity<>(respone, HttpStatus.NOT_FOUND);
	    }
	}