/**
 * 
 */
package com.example.service;

import com.example.model.ProductRequest;
import com.example.model.ProductResponse;

/**
 * @author Rama Krishna M
 *
 */
public interface ProductService {
    ProductResponse addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long productId);

    void reduceQuantity(long productId, long quantity);

    public void deleteProductById(long productId);


}
