package com.majorProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.majorProject.entity.Account;
import com.majorProject.entity.Customer;
import com.majorProject.entity.Transaction;
import com.majorProject.exception.TransactionException;
import com.majorProject.model.Dates;
import com.majorProject.model.TransactionData;
import com.majorProject.repository.AccountRepository;
import com.majorProject.repository.CustomerRepository;
import com.majorProject.repository.TransactionRepository;

@Service
@CrossOrigin
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public int transaction(TransactionData data,int amount) {
		Optional<Account> account=accountRepository.findById(data.getFromAccount());
		Optional<Account> account2=accountRepository.findById(data.getToAccount());
		if(data.getAmount()<=amount) {
		if(account.isPresent()) {
			Account acc=new Account();
			Account acc2=new Account();
			acc=account.get();
			acc2=account2.get();
			float balance=acc.getCurrentBalance();
			if(data.getAmount()<balance) {
				float updatedBalance=balance-data.getAmount();
				acc.setCurrentBalance(updatedBalance);
				acc2.setCurrentBalance(acc2.getCurrentBalance()+data.getAmount());
				Transaction transaction=new Transaction();
				transaction.setTransactionAmount(data.getAmount());
				transaction.setTransactionDate(data.getTransactionDate());
				transaction.setTransactionType(data.getTransactionType());
				transaction.setCustomer(acc.getCustomer());
				transaction.setSenderAccount(acc);
				transaction.setReceiverAccount(acc2);
				transactionRepository.save(transaction);
				return transaction.getTransactionId();
				
			}
			else {
				throw new TransactionException("Balance is insuffiecient");
			}
			
			
		}
		else {
			throw new TransactionException("Something error occured!");
		}
		}
		else {
			throw new TransactionException("Amount is not valid !");
		}
	}
	
	
	public List<Transaction> getTransactions(int customerid)
	{
		List<Transaction>trans=transactionRepository.findByCustomer(customerid);
//		List<Transaction> transactions=trans.get();
		
		return trans;
	}
	
	public List<Transaction> getTransactionsToAndFrom(Dates dates){
		List<Transaction>trans=transactionRepository.findTrans(dates.getDatefrom(), dates.getDateto(),dates.getCustomerid());
		return trans;
		
	}
	
	
	
	
	
	

}
