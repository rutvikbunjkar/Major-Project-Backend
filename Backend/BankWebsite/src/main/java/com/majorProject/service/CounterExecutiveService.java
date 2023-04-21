package com.majorProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.majorProject.entity.CounterExecutive;
import com.majorProject.entity.TokenDetails;
import com.majorProject.exception.CustomerServiceException;
import com.majorProject.repository.CounterExecutiveRepository;
import com.majorProject.repository.CounterRepository;


@Service
public class CounterExecutiveService {

	@Autowired
	CounterExecutiveRepository counterExecutiveRepository;
	@Autowired
	CounterRepository counterRepository;
	
	public CounterExecutive login(String name, String password) {
		
		List<CounterExecutive> allList = counterExecutiveRepository.findAll();
		
		for(CounterExecutive a : allList) {
			if(a.getName().equals(name) && a.getPassword().equals(password)) {
				return a;
			}			
		}
		return null;
	}

	public TokenDetails nextToken(int counterId, int tokenId) {
		
		
		
		return null;
	}

	public Integer getCounterExecutiveId(Integer CEid) {
		return counterRepository.findByCounterExecutiveId(CEid);
		
	}
		
//		Optional<CounterExecutive> counterExecutiveData = counterExecutiveRepository.findByName(name);
//		if(counterExecutiveData.isPresent()) {
//			CounterExecutive counterExecutive = counterExecutiveData.get();
//		
//				if(counterExecutiveRepository.existsByName(name) && counterExecutiveRepository.existsByPassword(password))
//				{
//					return counterExecutive;
//				}
//				else if(counterExecutiveRepository.existsByName(name)){
//					throw new CustomerServiceException("Enter Correct Password and try again :)");
//				}
//		}
//		else 
//			throw new CustomerServiceException("Account with given credentials doesn't exist..!");
}
