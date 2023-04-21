package com.majorProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.majorProject.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	

//	public Optional<Customer> findByCustomerId(int customerid);

	@Query("select c from Customer c where c.customerId=?1")
	public Optional<Customer> findByCustomerId(int customerid);
	
	boolean existsByAddharCardNumber(int addharCardNumber);

}
