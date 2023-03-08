/**
 * 
 */
package com.example.service;

import com.example.model.OrderRequest;
import com.example.model.OrderResponse;

/**
 * @author Rama Krishna M
 *
 */
public interface OrderService {
	    long placeOrder(OrderRequest orderRequest);

	    OrderResponse getOrderDetails(long orderId);
	}