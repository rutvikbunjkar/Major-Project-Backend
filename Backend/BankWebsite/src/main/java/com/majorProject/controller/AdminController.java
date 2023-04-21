package com.majorProject.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.majorProject.entity.Account;
import com.majorProject.entity.Customer;
import com.majorProject.entity.Customer.Status;
import com.majorProject.exception.CustomerServiceException;
import com.majorProject.model.CustomerLoginData;
import com.majorProject.model.LoginStatus;
import com.majorProject.repository.CustomerRepository;
import com.majorProject.service.AccountService;
import com.majorProject.service.AdminService;
import com.majorProject.service.CustomerService;
import com.majorProject.service.TransactionService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class AdminController {
	
	@Autowired
	private CustomerService customerService;

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private CustomerRepository custrepo;
	
//	int count = 0;
	
	@PostMapping("/adminlogin")
	public LoginStatus login(@RequestBody CustomerLoginData customerLoginData) {
		
		LoginStatus status = new LoginStatus();
		try {
			AdminService adminservice=new AdminService();
			status =adminservice.login(customerLoginData.getUsername(), customerLoginData.getPassword());
			status.setMesssageIfAny("successfully login");
			status.setStatus(true);
//			status.setCustomerid(count++); // this gives current value of count and then increases by 1
		} 
		catch (CustomerServiceException e) {
			status.setMesssageIfAny(e.getMessage());
		}
		return status;
	}
	
	@GetMapping("/changestatus")
	public Status changeStatus(@RequestParam int customerid)
	{
		
		 Customer cust=customerService.getCustomer(customerid);
		 System.out.println(cust);
		 if(cust.getStatus()!=Status.ACTIVE) {
		     
			 cust.setStatus(Status.ACTIVE);
			 custrepo.save(cust);
			 
		 }
		 else
		 {
			 cust.setStatus(Status.INACTIVE);
			 custrepo.save(cust);
			
		 }
		 return cust.getStatus();
		 
	}

    @GetMapping("/customer")
    public List<Customer> getAllCustomers() {
    	return customerService.getAllCustomers();
        
    }
    
    

	
	
	

}
