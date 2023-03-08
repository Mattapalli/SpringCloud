/**
 * 
 */
package com.example.service;

import com.example.model.PaymentRequest;
import com.example.model.PaymentResponse;

/**
 * @author Rama Krishna M
 *
 */
public interface PaymentService {
	long doPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetailsByOrderId(long orderId);

}
