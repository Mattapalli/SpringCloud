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

import com.example.model.OrderRequest;
import com.example.model.OrderResponse;
import com.example.service.OrderService;

/**
 * @author Rama Krishna M
 *
 */
@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	public OrderService orderService;

	@PostMapping("/placeorder")
	public ResponseEntity<Long> placeOrder(@RequestBody OrderRequest orderRequest) {

		// log.info("OrderController | placeOrder is called");

		// log.info("OrderController | placeOrder | orderRequest: {}",
		// orderRequest.toString());

		long orderId = orderService.placeOrder(orderRequest);
		// log.info("Order Id: {}", orderId);
		return new ResponseEntity<>(orderId, HttpStatus.OK);
	}

	@GetMapping("/{orderId}")
	public ResponseEntity<OrderResponse> getOrderDetails(@PathVariable("orderId") long orderId) {

		// log.info("OrderController | getOrderDetails is called");

		OrderResponse orderResponse = orderService.getOrderDetails(orderId);

		// log.info("OrderController | getOrderDetails | orderResponse : " +
		// orderResponse.toString());

		return new ResponseEntity<>(orderResponse, HttpStatus.OK);
	}
}
