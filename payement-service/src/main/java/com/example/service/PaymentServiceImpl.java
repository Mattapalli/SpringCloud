/**
 * 
 */
package com.example.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.TransactionDetailsRepository;
import com.example.entity.TransactionDetails;
import com.example.exception.PaymentServiceCustomException;
import com.example.model.PaymentMode;
import com.example.model.PaymentRequest;
import com.example.model.PaymentResponse;

/**
 * @author Rama Krishna M
 *
 */
@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	public TransactionDetailsRepository transactionDetailsRepository;

	@Override
	public long doPayment(PaymentRequest paymentRequest) {

	//	log.info("PaymentServiceImpl | doPayment is called");

	//	log.info("PaymentServiceImpl | doPayment | Recording Payment Details: {}", paymentRequest);

		TransactionDetails transactionDetails =new TransactionDetails();
		transactionDetails.setPaymentDate(Instant.now());
		transactionDetails.setPaymentMode(paymentRequest.getPaymentMode().getName());
		transactionDetails.setPaymentStatus("SUCCESS");
		transactionDetails.setOrderId(paymentRequest.getOrderId());
		transactionDetails.setReferenceNumber(paymentRequest.getReferenceNumber());
		transactionDetails.setAmount(paymentRequest.getAmount());
				
				
		/*
		 * .paymentDate(Instant.now())
		 * .paymentMode(paymentRequest.getPaymentMode().name()).paymentStatus("SUCCESS")
		 * 
		 * .orderId(paymentRequest.getOrderId()).referenceNumber(paymentRequest.
		 * getReferenceNumber()) .amount(paymentRequest.getAmount()).build();
		 */

		transactionDetails = transactionDetailsRepository.save(transactionDetails);

	//	log.info("Transaction Completed with Id: {}", transactionDetails.getId());

		return transactionDetails.getId();
	}

	@Override
	public PaymentResponse getPaymentDetailsByOrderId(long orderId) {

	//	log.info("PaymentServiceImpl | getPaymentDetailsByOrderId is called");

	//	log.info("PaymentServiceImpl | getPaymentDetailsByOrderId | Getting payment details for the Order Id: {}",
			//	orderId);

		TransactionDetails transactionDetails = transactionDetailsRepository.findByOrderId(orderId)
				.orElseThrow(() -> new PaymentServiceCustomException("TransactionDetails with given id not found",
						"TRANSACTION_NOT_FOUND"));
		
		PaymentResponse paymentResponse=new PaymentResponse();
		paymentResponse.setPaymentId(transactionDetails.getId());
		
		
		PaymentMode mode=new PaymentMode();
		mode.setName(transactionDetails.getPaymentMode());
		paymentResponse.setPaymentMode(mode);
		paymentResponse.setPaymentDate(transactionDetails.getPaymentDate());
		paymentResponse.setOrderId(transactionDetails.getOrderId());
		paymentResponse.setStatus(transactionDetails.getPaymentStatus());
		paymentResponse.setAmount(transactionDetails.getAmount());
		
		

		/*
		 * PaymentResponse paymentResponse =
		 * PaymentResponse.builder().paymentId(transactionDetails.getId())
		 * .paymentMode(PaymentMode.valueOf(transactionDetails.getPaymentMode()))
		 * .paymentDate(transactionDetails.getPaymentDate()).orderId(transactionDetails.
		 * getOrderId())
		 * .status(transactionDetails.getPaymentStatus()).amount(transactionDetails.
		 * getAmount()).build();
		 * 
		 * log.
		 * info("PaymentServiceImpl | getPaymentDetailsByOrderId | paymentResponse: {}",
		 * paymentResponse.toString());
		 */
		return paymentResponse;
	}
}