/**
 * 
 */
package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ProductRepository;
import com.example.entity.Product;
import com.example.exception.ProductServiceCustomException;
import com.example.model.ProductRequest;
import com.example.model.ProductResponse;

/**
 * @author Rama Krishna M
 *
 */

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	public ProductRepository productRepository;

	@Override
	public ProductResponse addProduct(ProductRequest productRequest) {
		// log.info("ProductServiceImpl | addProduct is called");

		Product product = new Product();
		product.setProductName(productRequest.getName());
		product.setQuantity(productRequest.getQuantity());
		product.setPrice(productRequest.getPrice());

		/*
		 * Product product =
		 * Product.builder().productName(productRequest.getName()).quantity(
		 * productRequest.getQuantity()) .price(productRequest.getPrice()).build();
		 */
		product = productRepository.save(product);
		ProductResponse productResponse = new ProductResponse();
		copyProperties(product,productResponse);

		/*
		 * log.info("ProductServiceImpl | addProduct | Product Created");
		 * log.info("ProductServiceImpl | addProduct | Product Id : " +
		 * product.getProductId());
		 */

		return productResponse;
	}

	@Override
	public ProductResponse getProductById(long productId) {

		/*
		 * log.info("ProductServiceImpl | getProductById is called"); log.
		 * info("ProductServiceImpl | getProductById | Get the product for productId: {}"
		 * , productId);
		 */

		Product product = productRepository.findById(productId).orElseThrow(
				() -> new ProductServiceCustomException("Product with given Id not found", "PRODUCT_NOT_FOUND"));

		ProductResponse productResponse = new ProductResponse();

		copyProperties(product, productResponse);

		// log.info("ProductServiceImpl | getProductById | productResponse :" +
		// productResponse.toString());

		return productResponse;
	}

	private void copyProperties(Product product, ProductResponse productResponse) {
		// TODO Auto-generated method stub
		productResponse.setProductId(product.getProductId());
		productResponse.setProductName(product.getProductName());
		productResponse.setQuantity(product.getQuantity());
		productResponse.setPrice(product.getPrice());

	}

	@Override
	public void reduceQuantity(long productId, long quantity) {

		//log.info("Reduce Quantity {} for Id: {}", quantity, productId);

		Product product = productRepository.findById(productId).orElseThrow(
				() -> new ProductServiceCustomException("Product with given Id not found", "PRODUCT_NOT_FOUND"));

		if (product.getQuantity() < quantity) {
			throw new ProductServiceCustomException("Product does not have sufficient Quantity",
					"INSUFFICIENT_QUANTITY");
		}

		product.setQuantity(product.getQuantity() - quantity);
		productRepository.save(product);
	//	log.info("Product Quantity updated Successfully");
	}

	@Override
	public void deleteProductById(long productId) {
	//	log.info("Product id: {}", productId);

		if (!productRepository.existsById(productId)) {
		//	log.info("Im in this loop {}", !productRepository.existsById(productId));
			throw new ProductServiceCustomException("Product with given with Id: " + productId + " not found:",
					"PRODUCT_NOT_FOUND");
		}
		//log.info("Deleting Product with id: {}", productId);
		productRepository.deleteById(productId);

	}
}