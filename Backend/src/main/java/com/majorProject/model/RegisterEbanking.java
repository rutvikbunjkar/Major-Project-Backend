package com.majorProject.model;

public class RegisterEbanking {
	
	private int accountNumber;
	private String username;
	private String password;
	private int transactionPin;
	private int otp;
	
	
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getTransactionPin() {
		return transactionPin;
	}
	public void setTransactionPin(int transactionPin) {
		this.transactionPin = transactionPin;
	}
	
	
}