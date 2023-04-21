package com.majorProject.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.majorProject.entity.Customer.Status;

@Entity
public class Customer  {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
	private int customerId;

	@Column(name="addhar_card_number")
	private int addharCardNumber;

	@Column(name="date_of_birth")
	
	private Date dateOfBirth;

	private String email;

	@Column(name="fathers_name")
	private String fathersName;

	@Column(name="first_name")
	private String firstName;

	@Column(name="gross_annual_income")
	private float grossAnnualIncome;

	@Column(name="last_name")
	private String lastName;

	@Column(name="mobile_number")
	private String mobileNumber;

	@Column(name="source_of_income")
	private String sourceOfIncome;

	@OneToOne(mappedBy="customer", cascade = CascadeType.ALL)
	private Address address;

	//bi-directional many-to-one association to Beneficiary
	@OneToMany(mappedBy="customerBeneficiary")
	@JsonIgnore
	private List<Beneficiary> beneficiaries;

	//bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy="customer")
	@JsonIgnore
	private List<Transaction> transactions;
	
	@OneToOne(mappedBy = "customer")
	@JsonIgnore
	private Account account;
	
	@Enumerated(EnumType.STRING) //we specify this to store the data of the enum value in database	
	private Status status;
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public static enum Status{
		ACTIVE,INACTIVE,LOCKED;
	}

	public Customer() {
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getAddharCardNumber() {
		return this.addharCardNumber;
	}

	public void setAddharCardNumber(int addharCardNumber) {
		this.addharCardNumber = addharCardNumber;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFathersName() {
		return this.fathersName;
	}

	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public float getGrossAnnualIncome() {
		return this.grossAnnualIncome;
	}

	public void setGrossAnnualIncome(float grossAnnualIncome) {
		this.grossAnnualIncome = grossAnnualIncome;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getSourceOfIncome() {
		return this.sourceOfIncome;
	}

	public void setSourceOfIncome(String sourceOfIncome) {
		this.sourceOfIncome = sourceOfIncome;
	}

	public List<Beneficiary> getBeneficiaries() {
		return this.beneficiaries;
	}

	public void setBeneficiaries(List<Beneficiary> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}

	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Transaction addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
		transaction.setCustomer(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setCustomer(null);

		return transaction;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", addharCardNumber=" + addharCardNumber + ", dateOfBirth="
				+ dateOfBirth + ", email=" + email + ", fathersName=" + fathersName + ", firstName=" + firstName
				+ ", grossAnnualIncome=" + grossAnnualIncome + ", lastName=" + lastName + ", mobileNumber="
				+ mobileNumber + ", sourceOfIncome=" + sourceOfIncome + ", address=" + address + ", beneficiaries="
				+ beneficiaries + ", transactions=" + transactions + ", account=" + account + ", status=" + status
				+ "]";
	}
	
	

}