/**
 * 
 */
package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.PaymentRequest;
import com.example.model.PaymentResponse;
import com.example.service.PaymentService;

/**
 * @author Rama Krishna M
 *
 */
@RestController
@RequestMapping("/payments")
public class PaymentController {
	@Autowired
	public PaymentService paymentService;

	@PostMapping("/payment")
	public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest) {

		// log.info("PaymentController | doPayment is called");

		// log.info("PaymentController | doPayment | paymentRequest : " +
		// paymentRequest.toString());

		return new ResponseEntity<>(paymentService.doPayment(paymentRequest), HttpStatus.OK);
	}

	@GetMapping("/order/{orderId}")
	public ResponseEntity<PaymentResponse> getPaymentDetailsByOrderId(@PathVariable("orderId") long orderId) {

		// log.info("PaymentController | doPayment is called");

		// log.info("PaymentController | doPayment | orderId : " + orderId);

		return new ResponseEntity<>(paymentService.getPaymentDetailsByOrderId(orderId), HttpStatus.OK);
	}
}