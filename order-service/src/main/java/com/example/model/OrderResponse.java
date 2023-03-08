/**
 * 
 */
package com.example.model;

import java.time.Instant;

/**
 * @author Rama Krishna M
 *
 */
public class OrderResponse {

	private long orderId;
	private Instant orderDate;
	private String orderStatus;
	private long amount;
	private ProductDetails productDetails;
	private PaymentDetails paymentDetails;
	/**
	 * @return the orderId
	 */
	public long getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the orderDate
	 */
	public Instant getOrderDate() {
		return orderDate;
	}
	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Instant orderDate) {
		this.orderDate = orderDate;
	}
	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}
	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	/**
	 * @return the amount
	 */
	public long getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(long amount) {
		this.amount = amount;
	}
	/**
	 * @return the productDetails
	 */
	public ProductDetails getProductDetails() {
		return productDetails;
	}
	/**
	 * @param productDetails the productDetails to set
	 */
	public void setProductDetails(ProductDetails productDetails) {
		this.productDetails = productDetails;
	}
	/**
	 * @return the paymentDetails
	 */
	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}
	/**
	 * @param paymentDetails the paymentDetails to set
	 */
	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	
	

}
