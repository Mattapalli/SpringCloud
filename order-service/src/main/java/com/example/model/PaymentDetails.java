/**
 * 
 */
package com.example.model;

import java.time.Instant;

/**
 * @author Rama Krishna M
 *
 */
public class PaymentDetails {
	
	  private long paymentId;
      private PaymentMode paymentMode;
      private String paymentStatus;
      private Instant paymentDate;
	/**
	 * @return the paymentId
	 */
	public long getPaymentId() {
		return paymentId;
	}
	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}
	/**
	 * @return the paymentMode
	 */
	public PaymentMode getPaymentMode() {
		return paymentMode;
	}
	/**
	 * @param paymentMode the paymentMode to set
	 */
	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}
	/**
	 * @return the paymentStatus
	 */
	public String getPaymentStatus() {
		return paymentStatus;
	}
	/**
	 * @param paymentStatus the paymentStatus to set
	 */
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	/**
	 * @return the paymentDate
	 */
	public Instant getPaymentDate() {
		return paymentDate;
	}
	/**
	 * @param paymentDate the paymentDate to set
	 */
	public void setPaymentDate(Instant paymentDate) {
		this.paymentDate = paymentDate;
	}
      
      

}
