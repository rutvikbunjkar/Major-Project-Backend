package com.majorProject.service;

import java.nio.channels.AcceptPendingException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.majorProject.entity.Account;
import com.majorProject.entity.Customer;
import com.majorProject.exception.CustomerServiceException;
import com.majorProject.model.AccountStatementDetail;
import com.majorProject.model.Status;
import com.majorProject.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;

	CustomerService customerservice = new CustomerService();

	public Status forgotpassword(int accountNumber) {
		if (accountRepository.existsById(accountNumber)) {
			Status status = new Status();
			status.setStatus(true);
			status.setMesssageIfAny("user present");
			return status;
		} else {
			throw new CustomerServiceException("Enter Correct Username");
		}
	}

	public AccountStatementDetail findDetails(String username) {
		if (accountRepository.existsByUsername(username).isPresent() ) {
			Optional<Account> account = accountRepository.findByUsername(username);
			Account details = account.get();
			AccountStatementDetail accountdetails = new AccountStatementDetail();
			accountdetails.setAccountNumber(details.getAccountId());
			accountdetails.setAccountType(details.getAccountType());
			accountdetails.setBalance(details.getCurrentBalance());
			accountdetails.setName(details.getUsername());
			accountdetails.setCustomerid(details.getCustomer().getCustomerId());
			return accountdetails;
		} else {
			throw new CustomerServiceException("User not present.. please enter valid account number");
		}
	}

	public Customer findAccountId(String username) {
		if (accountRepository.findByUsername(username) != null) {
			Optional<Account> account = accountRepository.findByUsername(username);
			Account details = account.get();
			return details.getCustomer();
		} else {
			throw new CustomerServiceException("User not present");
		}
	}

	public Account findByUsername(String username) {
		Optional<Account> acc = accountRepository.findByUsername(username);
		Account account = acc.get();
		return account;
	}
	
}
