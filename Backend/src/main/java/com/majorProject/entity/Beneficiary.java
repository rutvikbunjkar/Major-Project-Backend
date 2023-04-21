package com.majorProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Beneficiary  {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int beneficiary_id;
	
	@Column(name="account_number")
	private int accountNumber;

	private String name;

	@Column(name="nick_name")
	private String nickName;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customer_id")
	@JsonIgnore
	private Customer customerBeneficiary;

	public Beneficiary() {
	}

	public int getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getBeneficiary_id() {
		return beneficiary_id;
	}

	public void setBeneficiary_id(int beneficiary_id) {
		this.beneficiary_id = beneficiary_id;
	}

	public Customer getCustomerBeneficiary() {
		return customerBeneficiary;
	}

	public void setCustomerBeneficiary(Customer customerBeneficiary) {
		this.customerBeneficiary = customerBeneficiary;
	}

	

}