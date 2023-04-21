package com.majorProject.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.majorProject.entity.Account;
import com.majorProject.entity.Transaction;
import com.majorProject.model.Dates;


public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
//	
//	@Query("select t from Transaction t where t.customerid = ?1")
//	public List<Transaction> fetchByCustomerId(int customerid);// 

	
	@Query("select t from Transaction t where t.customer.id = ?1")
	List<Transaction> findByCustomer(int customerid);
	
	
	@Query("select t from Transaction t where t.transactionDate >=?1 and t.transactionDate <= ?2 and t.customer.id = ?3")
	List<Transaction> findTrans(Date date1,Date date2,int customerid);
	
//	public Optional<List<Transaction>> findByCustomerid(int customerid);
}
