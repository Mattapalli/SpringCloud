/**
 * 
 */
package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Product;
import com.example.model.ProductRequest;
import com.example.model.ProductResponse;
import com.example.service.ProductService;

/**
 * @author Rama Krishna M
 *
 */
@RestController
@RequestMapping("/products")

public class ProductController {

	@Autowired
	public ProductService productService;

	@PostMapping
	public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest productRequest) {

		// log.info("ProductController | addProduct is called");

		// log.info("ProductController | addProduct | productRequest : " +
		// productRequest.toString());

		ProductResponse product= productService.addProduct(productRequest);
		return new ResponseEntity<>(product, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") long productId) {

		// log.info("ProductController | getProductById is called");

		// log.info("ProductController | getProductById | productId : " + productId);

		ProductResponse productResponse = productService.getProductById(productId);
		return new ResponseEntity<>(productResponse, HttpStatus.OK);
	}

	@PutMapping("/reduceQuantity/{id}")
	public ResponseEntity<String> reduceQuantity(@PathVariable("id") long productId, @RequestBody ProductRequest request ) {

		// log.info("ProductController | reduceQuantity is called");

		// log.info("ProductController | reduceQuantity | productId : " + productId);
		// log.info("ProductController | reduceQuantity | quantity : " + quantity);

		productService.reduceQuantity(productId, request.getQuantity());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public void deleteProductById(@PathVariable("id") long productId) {
		productService.deleteProductById(productId);
	}
	
}