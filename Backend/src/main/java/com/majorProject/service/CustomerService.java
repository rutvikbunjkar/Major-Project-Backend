package com.majorProject.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.majorProject.entity.Account;
import com.majorProject.entity.Beneficiary;
import com.majorProject.entity.Customer;
import com.majorProject.entity.Customer.Status;
import com.majorProject.exception.CustomerServiceException;
import com.majorProject.model.LoginStatus;
import com.majorProject.model.PasswordDetail;
import com.majorProject.model.RegisterEbanking;
import com.majorProject.repository.AccountRepository;
import com.majorProject.repository.BeneficiaryRepository;
import com.majorProject.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRespository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private BeneficiaryRepository beneficiaryRepository;

	private int registrationOtp;// here we save the otp send to customer for verification

	public int register(Customer customer) {
		if (!customerRespository.existsByAddharCardNumber(customer.getAddharCardNumber())) {
			customer.setStatus(Status.INACTIVE);
//			customer.getAddress().setCustomer(customer);// here we are setting the customer column refernce in Address
														// table
			customerRespository.save(customer);
			return customer.getCustomerId();
		} else {
			throw new CustomerServiceException("User already registered");
		}

	}

	private char[] OTP(int len) {
		String numbers = "0123456789";

		Random rndm_method = new Random();

		char[] otp = new char[len];

		for (int i = 0; i < len; i++) {
			// Use of charAt() method : to get character value
			// Use of nextInt() as it is scanning the value as int
			otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
		}
		return otp;
	}

	public void verifyAccount(int accountNumber) {
		Optional<Account> acc = accountRepository.findById(accountNumber);
//		Optional<Customer> cust = customerRespository.findById(acc.get().getCustomer().getCustomerId());
		if (acc.isPresent()) {
			char[] otp = OTP(4);
			registrationOtp = Integer.parseInt(new String(otp));
			acc.get().setOtp(Integer.parseInt(new String(otp)));
			System.out.println("your otp is " + registrationOtp);
		} else {
			throw new CustomerServiceException("Account number does not exixt..");
		}

	}

//	public void sendEmail(String toEmail,String subject,String body) {
//		SimpleMailMessage message=new SimpleMailMessage();
//		message.setFrom("amitthelkar7620@gmail.com");
//		message.setTo(toEmail);
//		message.setText(body);
//		message.setSubject(subject);
//		mailSender.send(message);
//		
//		System.out.println("mail sent succesfully....");
//	}

	public void registerForEbanking(RegisterEbanking registerData) {
		Optional<Account> account = accountRepository.findById(registerData.getAccountNumber());
		if (account.isPresent()) {
			if (registerData.getOtp() == account.get().getOtp()) {
				Account acc = account.get();
				acc.setUsername(registerData.getUsername());
				acc.setPassword(registerData.getPassword());
				acc.setTransactionPin(registerData.getTransactionPin());
				accountRepository.save(acc); 
			} else {
				throw new CustomerServiceException("Please enter correct otp.");
			}
		} else {
			throw new CustomerServiceException("Your account Does not exists contact to admin.");
		}
	}

	public Customer login(String username, String password) {
		System.out.println(accountRepository.findByPassword(password));
		if (accountRepository.existsByUsername(username).isPresent() && accountRepository.findByPassword(password)!=null) {
			Optional<Account> account = accountRepository.findByUsername(username);
			Account accountdata = account.get();
			if (accountdata.getCustomer().getStatus() != Status.INACTIVE) {
				if (password.equals(accountdata.getPassword())) {
					System.out.println("successfully login");
					return accountdata.getCustomer();
				}else {
					throw new CustomerServiceException("Enter correct password");
				}
			}else {
				throw new CustomerServiceException("Account is Locked");
			}
		}else {
			System.out.println("user not exist");
			throw new CustomerServiceException("user not exist");
		}
	}

	public Customer customerdetail(int customerid) {
		System.out.println(customerid);
		Optional<Customer> cust = customerRespository.findById(customerid);
		Customer customer = cust.get();
		return customer;
	}

	public LoginStatus changepassword(PasswordDetail passdetail) {

		LoginStatus status = new LoginStatus();
		if (accountRepository.existsByUsername(passdetail.getUsername()).isPresent()) {
			Optional<Account> acc = accountRepository.findByUsername(passdetail.getUsername());
			Account account = acc.get();

			if (passdetail.getOldpassword().equals(account.getPassword())) {
				if (passdetail.getPassword().equals(passdetail.getConfirmpassword())) {
					status.setStatus(true);
					status.setMesssageIfAny("password changed successfully");
					account.setPassword(passdetail.getPassword());

					accountRepository.save(account);
					System.out.println(account.getPassword());

					System.out.println("password changed successfully");

				} else {
					status.setMesssageIfAny("password not match");
					throw new CustomerServiceException("Password Not Match");
				}

			} else {
				status.setMesssageIfAny("Enter Valid Old Password");
				throw new CustomerServiceException("Enter Valid Old Password");
			}
		} else {
			status.setMesssageIfAny("user not present");
			throw new CustomerServiceException("user not present");
		}
		return status;

	}

	public Customer getCustomer(int id) {
		Optional<Customer> customer = customerRespository.findById(id);
		if (customer.isPresent()) {
			return customer.get();
		} else {
			throw new CustomerServiceException("No such customer id exists");
		}

	}

	public void addBeneficiary(Beneficiary beneficiary) {
		beneficiaryRepository.save(beneficiary);
	}

	public Account getAccount(int id) {
		Optional<Customer> customer = customerRespository.findById(id);
		Account acc = customer.get().getAccount();
		return acc;
	}

	public List<Customer> getAllCustomers() {

		return customerRespository.findAll();
	}

	public List<Beneficiary> fetchBenficiary(int id) {
		List<Beneficiary> beneficiary = beneficiaryRepository.findByCustomerId(id);
//		System.out.println(beneficiary.get(0).getName());
		return beneficiary;

	}

//	public List<Beneficiary> fetchBenficiary(int id) {
//		
//		return null;
//	}

}
