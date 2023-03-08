/**
 * 
 */
package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Product;

/**
 * @author Rama Krishna M
 *
 */
@Repository
public interface ProductRepository  extends JpaRepository<Product,Long> {

}
