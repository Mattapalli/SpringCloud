/**
 * 
 */
package com.example.exception;

/**
 * @author Rama Krishna M
 *
 */
public class PaymentServiceCustomException extends RuntimeException {

	private final String errorCode;

	public PaymentServiceCustomException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}
	
	
}
