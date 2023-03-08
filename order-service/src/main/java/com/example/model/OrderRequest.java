/**
 * 
 */
package com.example.model;

/**
 * @author Rama Krishna M
 *
 */
public class OrderRequest {
	   private long productId;
	    private long totalAmount;
	    private long quantity;
	    private PaymentMode paymentMode;
		/**
		 * @return the productId
		 */
		public long getProductId() {
			return productId;
		}
		/**
		 * @param productId the productId to set
		 */
		public void setProductId(long productId) {
			this.productId = productId;
		}
		/**
		 * @return the totalAmount
		 */
		public long getTotalAmount() {
			return totalAmount;
		}
		/**
		 * @param totalAmount the totalAmount to set
		 */
		public void setTotalAmount(long totalAmount) {
			this.totalAmount = totalAmount;
		}
		/**
		 * @return the quantity
		 */
		public long getQuantity() {
			return quantity;
		}
		/**
		 * @param quantity the quantity to set
		 */
		public void setQuantity(long quantity) {
			this.quantity = quantity;
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
	    
	    
	    

}
