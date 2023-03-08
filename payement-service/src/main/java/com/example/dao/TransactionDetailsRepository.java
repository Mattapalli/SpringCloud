/**
 * 
 */
package com.example.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.TransactionDetails;

/**
 * @author Rama Krishna M
 *
 */
@Repository
public interface TransactionDetailsRepository  extends JpaRepository<TransactionDetails, Long> {

    Optional<TransactionDetails> findByOrderId(long orderId);
}