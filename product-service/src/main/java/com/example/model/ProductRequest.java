/**
 * 
 */
package com.example.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author Rama Krishna M
 *
 */


public class ProductRequest {
	private String name;
	private long price;
	private long quantity;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "ProductRequest [name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}
	

}
