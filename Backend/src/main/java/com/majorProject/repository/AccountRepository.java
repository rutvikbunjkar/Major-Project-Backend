package com.majorProject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.majorProject.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

	boolean findByAccountId(int accountNumber);
	
	@Query("select a from Account a where a.username = ?1")
	public Optional<Account> existsByUsername(String username);// verify user is present or not

	public Optional<Account> findByUsername(String username);// return user details
	
	@Query("select a from Account a where a.username = ?1")
	public List<Account> findByUsername2(String username);// return user details

	boolean existsByAccountId(int accountnumber);

	@Query("select a from Account a where a.customer.id = ?1")
	Optional<Account> findByCustomer(int customerid);
	
	@Query("select a.password from Account a where a.password=?1")
	String findByPassword(String password);
	
}
