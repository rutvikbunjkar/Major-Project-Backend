package com.majorProject.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.majorProject.entity.ServiceType;
import com.majorProject.entity.TokenDetails;
import com.majorProject.model.ServiceDTO;
import com.majorProject.model.ServiceTypeDTO;
import com.majorProject.model.TokenDTO;
import com.majorProject.repository.TokenDetailsRepository;
import com.majorProject.service.TokenService;

@RestController
@CrossOrigin
public class TokenController {

	@Autowired
	private TokenDetailsRepository tokenDetailsRepo;

	@Autowired
	private TokenService tokenService;

	@PostMapping("/generateToken")
	public String insertTokenInDatabase(@RequestBody TokenDetails tokenDetails) {
		System.out.println("we are inside generating token");
		return tokenService.generateToken(tokenDetails);
	}

	@GetMapping("/requestingQueue")
	public Queue<TokenDTO> returnQueueOfTokens(@RequestParam("counterId") Integer counterId) {
		List<TokenDetails> list = tokenService.queueOfTokens(counterId);
		List<TokenDTO> list2 = new LinkedList<>();
		Queue<TokenDTO> q = new LinkedList<>();
		for (TokenDetails t : list) {
			TokenDTO obj = new TokenDTO();
			obj.setServiceId(t.getService().getServiceId());
			obj.setExpectedWaitTime(t.getExpectedWaitTime());
			obj.setStatus(t.getStatus());
			obj.setTokenGenerationTime(t.getTokenGenerationTime());
			obj.setTokenId(t.getTokenId());
			obj.setServiceDescription(t.getService().getServiceName());
			list2.add(obj);
			if (t.getStatus().equals("ACTIVE")) {
				q.add(obj);
			}
		}
		System.out.println("Controller is returning the list");

		return q;
	}

	@GetMapping("/requestingWaitingQueue")
	public Queue<TokenDTO> returnWaitingQueueOfTokens(@RequestParam("counterId") Integer counterId) {
		List<TokenDetails> list = tokenService.queueOfTokens(counterId);
		List<TokenDTO> list2 = new LinkedList<>();
		Queue<TokenDTO> waitingQueue = new LinkedList<>();
		for (TokenDetails t : list) {
			TokenDTO obj = new TokenDTO();
			obj.setServiceId(t.getService().getServiceId());
			obj.setExpectedWaitTime(t.getExpectedWaitTime());
			obj.setStatus(t.getStatus());
			obj.setTokenGenerationTime(t.getTokenGenerationTime());
			obj.setTokenId(t.getTokenId());
			obj.setServiceDescription(t.getService().getServiceName());
			list2.add(obj);
			if (t.getStatus().equals("WAITING")) {
				waitingQueue.add(obj);
			}
		}
		System.out.println("Controller is returning the waitingQueue");
		return waitingQueue;
	}

	@GetMapping("/getServicesTypesForTokenGeneration")
	public List<ServiceTypeDTO> getServicesTypesForTokenGeneration() {
		List<ServiceType> serviceTypes = tokenService.getServicesTypesForTokenGeneration();
		List<ServiceTypeDTO> serviceTypeDTOs = new ArrayList<>();
		for (ServiceType serviceType : serviceTypes) {
			ServiceTypeDTO serviceTypeDTO = new ServiceTypeDTO();
			serviceTypeDTO.setId(serviceType.getId());
			serviceTypeDTO.setTypeOfService(serviceType.getTypeOfService());
			List<ServiceDTO> serviceDTOs = new ArrayList<>();
			for (com.majorProject.entity.Service service : serviceType.getServices()) {
				ServiceDTO serviceDTO = new ServiceDTO();
				serviceDTO.setId(service.getServiceId());
				serviceDTO.setServiceName(service.getServiceName());
				serviceDTO.setStatusOfService(service.getStatusOfService());
				serviceDTOs.add(serviceDTO);
			}
			serviceTypeDTO.setServices(serviceDTOs);
			serviceTypeDTOs.add(serviceTypeDTO);
		}
		return serviceTypeDTOs;
	}

	@GetMapping("/statusWaiting")
	public String changeStatusToWaiting(@RequestParam("tokenId") Integer tokenId) {
		String msg = tokenService.changeStatusToWaiting(tokenId);
		return msg;
	}

	@GetMapping("/resolved")
	public String resolved(@RequestParam("tokenId") Integer tokenId) {
		String msg = tokenService.resolved(tokenId);
		return msg;
	}

}
