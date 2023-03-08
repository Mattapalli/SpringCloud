/**
 * 
 */
package com.example.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Rama Krishna M
 *
 */
@Data
@Getter 
@Setter
public class ProductServiceCustomException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String errorCode;

	public ProductServiceCustomException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	
}
