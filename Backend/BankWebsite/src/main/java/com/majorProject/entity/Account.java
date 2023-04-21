package com.majorProject.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Account  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="account_id")
	private int accountId;

	@Column(name="account_type")
	private String accountType;

	@Column(name="current_balance")
	private float currentBalance;

	private String password;

	private String username;
	
	private int transactionPin;

	

	@OneToOne
	@JoinColumn(name="customer_id")
	@JsonIgnore
	private Customer customer;

	//bi-directional many-to-one association to Transaction
//	@OneToMany(mappedBy="account")
//	private List<Transaction> transactions;
	
	@OneToMany(mappedBy="senderAccount")
	@JsonIgnore
	private List<Transaction> senderTransactions;
	
	@OneToMany(mappedBy = "receiverAccount")
	@JsonIgnore
	private List<Transaction> receiverTransactions;
	
	private int otp;

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public Account() {
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return this.accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public float getCurrentBalance() {
		return this.currentBalance;
	}

	public void setCurrentBalance(float currentBalance) {
		this.currentBalance = currentBalance;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

//	public List<Transaction> getTransactions() {
//		return this.transactions;
//	}
//
//	public void setTransactions(List<Transaction> transactions) {
//		this.transactions = transactions;
//	}
//
//	public Transaction addTransaction(Transaction transaction) {
//		getTransactions().add(transaction);
//		transaction.setAccount(this);
//
//		return transaction;
//	}
//
//	public Transaction removeTransaction(Transaction transaction) {
//		getTransactions().remove(transaction);
//		transaction.setAccount(null);
//
//		return transaction;
//	}
	public int getTransactionPin() {
		return transactionPin;
	}

	public void setTransactionPin(int transactionPin) {
		this.transactionPin = transactionPin;
	}

	public List<Transaction> getSenderTransactions() {
		return senderTransactions;
	}

	public void setSenderTransactions(List<Transaction> senderTransactions) {
		this.senderTransactions = senderTransactions;
	}

	public List<Transaction> getReceiverTransactions() {
		return receiverTransactions;
	}

	public void setReceiverTransactions(List<Transaction> receiverTransactions) {
		this.receiverTransactions = receiverTransactions;
	}
	
	

}