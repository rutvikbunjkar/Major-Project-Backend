package com.majorProject.service;



import com.majorProject.exception.CustomerServiceException;
import com.majorProject.model.LoginStatus;
import com.majorProject.model.Status;

public class AdminService {

	
	
	public LoginStatus login(String username, String password) {
		LoginStatus status=new LoginStatus();
		if (username.equals("Amit@1234") )  {
			if (password.equals("Amit@1234")) {
				
				System.out.println("successfully login");
					status.setStatus(true);
					status.setMesssageIfAny("successfully login");
					return status;
				} else {
					throw new CustomerServiceException("Enter correct Admin Name or password");

				}
			}
		
		else if (username.equals("Pratik@1234") )  {
			if (password.equals("Pratik@1234")) {
//				Status status=new Status();
				System.out.println("successfully login");
					status.setStatus(true);
					status.setMesssageIfAny("successfully login");
					return status;
				} else {
					throw new CustomerServiceException("Enter correct Admin Name or password");

				}
			}
		
		else if (username.equals("Anushree@1234") )  {
			if (password.equals("Anushree@1234")) {
//				Status status=new Status();
				System.out.println("successfully login");
					status.setStatus(true);
					status.setMesssageIfAny("successfully login");
					return status;
				} else {
					throw new CustomerServiceException("Enter correct Admin Name or password");

				}
			}
		
		status.setStatus(false);
	status.setMesssageIfAny("enter correct admin name");
		return status;
		

	}
}
