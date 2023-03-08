/**
 * 
 */
package com.example.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Rama Krishna M
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
	private String errorMessage;
	private String errorCode;
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	@Override
	public String toString() {
		return "ErrorResponse [errorMessage=" + errorMessage + ", errorCode=" + errorCode + "]";
	}
	
	

}
