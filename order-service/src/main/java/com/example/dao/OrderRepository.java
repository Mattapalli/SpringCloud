/**
 * 
 */
package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Order;

/**
 * @author Rama Krishna M
 *
 */
@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

}
