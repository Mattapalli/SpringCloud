/**
 * 
 */
package com.example.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dao.OrderRepository;
import com.example.entity.Order;
import com.example.exception.OrderServiceCustomException;
import com.example.model.OrderRequest;
import com.example.model.OrderResponse;
import com.example.model.PaymentDetails;
import com.example.model.PaymentRequest;
import com.example.model.PaymentResponse;
import com.example.model.ProductDetails;
import com.example.model.ProductResponse;

/**
 * @author Rama Krishna M
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	public OrderRepository orderRepository;
	@Autowired
	public RestTemplate restTemplate;

	@Override
	public long placeOrder(OrderRequest orderRequest) {

		// log.info("OrderServiceImpl | placeOrder is called");

		// Order Entity -> Save the data with Status Order Created
		// Product Service - Block Products (Reduce the Quantity)
		// Payment Service -> Payments -> Success-> COMPLETE, Else
		// CANCELLED

		// log.info("OrderServiceImpl | placeOrder | Placing Order Request orderRequest
		// : " + orderRequest.toString());

		// log.info("OrderServiceImpl | placeOrder | Creating Order with Status
		// CREATED");
		Order order = new Order();
		order.setAmount(orderRequest.getTotalAmount());
		order.setOrderStatus("CREATED");
		order.setProductId(orderRequest.getProductId());
		order.setOrderDate(Instant.now());
		order.setQuantity(orderRequest.getQuantity());

		order = orderRepository.save(order);

		// log.info("OrderServiceImpl | placeOrder | Calling Payment Service to complete
		// the payment");

		PaymentRequest paymentRequest = new PaymentRequest();
		paymentRequest.setOrderId(order.getId());
		paymentRequest.setPaymentMode(orderRequest.getPaymentMode());
		paymentRequest.setAmount(orderRequest.getTotalAmount());

		String orderStatus = null;

		try {
			// log.info("OrderServiceImpl | placeOrder | Payment done Successfully. Changing
			// the Oder status to PLACED");
			orderStatus = "PLACED";
		} catch (Exception e) {
			// log.error(
			// "OrderServiceImpl | placeOrder | Error occurred in payment. Changing order
			// status to PAYMENT_FAILED");

			orderStatus = "PAYMENT_FAILED";
		}

		order.setOrderStatus(orderStatus);

		orderRepository.save(order);

		// log.info("OrderServiceImpl | placeOrder | Order Places successfully with
		// Order Id: {}", order.getId());

		return order.getId();
	}

	@Override
	public OrderResponse getOrderDetails(long orderId) {

		// log.info("OrderServiceImpl | getOrderDetails | Get order details for Order Id
		// : {}", orderId);

		Order order = orderRepository.findById(orderId).orElseThrow(
				() -> new OrderServiceCustomException("Order not found for the order Id:" + orderId, "NOT_FOUND", 404));
		System.out.println(order.toString());
		System.out.println(order.getId());
		System.out.println(order.getProductId());
		// log.info("OrderServiceImpl | getOrderDetails | Invoking Product service to
		// fetch the product for id: {}",
		// order.getProductId());

		OrderResponse orderResponse = new OrderResponse();
		
		//	String productServiceUlr = "http://localhost:9001/product/" + order.getProductId();
			
	String productServiceUlr = "http://PRODUCT-SERVICE/products/" + order.getProductId();
		System.out.println(productServiceUlr);
		ProductResponse productResponse = restTemplate.getForObject(productServiceUlr, ProductResponse.class);
		System.out.println(productResponse.toString());
		// log.info("OrderServiceImpl | getOrderDetails | Getting payment information
		// form the payment Service");
		
		String payment_url = "http://PAYMENT-SERVICE/payments/order/" + order.getId();
	//	String payment_url = "http://localhost:9003/order/" + order.getId();
	
		PaymentResponse paymentResponse = restTemplate.getForObject(payment_url, PaymentResponse.class);
		System.out.println(paymentResponse.toString());

		orderResponse.setOrderId(order.getId());
		orderResponse.setOrderStatus(order.getOrderStatus());
		orderResponse.setAmount(order.getAmount());
		orderResponse.setOrderDate(order.getOrderDate());

		ProductDetails productDetails = new ProductDetails();
		productDetails.setProductName(productResponse.getProductName());
		productDetails.setProductId(productResponse.getProductId());
		productDetails.setQuantity(productResponse.getQuantity());
		productDetails.setPrice(productResponse.getPrice());
		orderResponse.setProductDetails(productDetails);

		/*
		 * OrderResponse.ProductDetails productDetails =
		 * OrderResponse.ProductDetails.builder()
		 * .productName(productResponse.getProductName()).productId(productResponse.
		 * getProductId()).build();
		 */

		PaymentDetails paymentDetails = new PaymentDetails();
		paymentDetails.setPaymentId(paymentResponse.getPaymentId());
		paymentDetails.setPaymentStatus(paymentResponse.getStatus());
		paymentDetails.setPaymentDate(paymentResponse.getPaymentDate());
		paymentDetails.setPaymentMode(paymentResponse.getPaymentMode());

		orderResponse.setPaymentDetails(paymentDetails);

		/*
		 * OrderResponse.PaymentDetails paymentDetails =
		 * OrderResponse.PaymentDetails.builder()
		 * .paymentId(paymentResponse.getPaymentId()).paymentStatus(paymentResponse.
		 * getStatus())
		 * .paymentDate(paymentResponse.getPaymentDate()).paymentMode(paymentResponse.
		 * getPaymentMode()).build();
		 */

		/*
		 * OrderResponse orderResponse =
		 * OrderResponse.builder().orderId(order.getId()).orderStatus(order.
		 * getOrderStatus())
		 * .amount(order.getAmount()).orderDate(order.getOrderDate()).productDetails(
		 * productDetails) .paymentDetails(paymentDetails).build();
		 */

		// log.info("OrderServiceImpl | getOrderDetails | orderResponse : " +
		// orderResponse.toString());

		return orderResponse;
	}
}