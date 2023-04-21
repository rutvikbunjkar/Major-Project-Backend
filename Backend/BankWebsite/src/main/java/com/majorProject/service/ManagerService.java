package com.majorProject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.majorProject.entity.Counter;
import com.majorProject.entity.CounterExecutive;
import com.majorProject.entity.ServiceType;
import com.majorProject.model.*;
import com.majorProject.repository.CounterExecutiveRepository;
import com.majorProject.repository.CounterRepository;
import com.majorProject.repository.ServiceRepository;
import com.majorProject.repository.ServiceTypeRepository;

@Service
public class ManagerService {
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;
    @Autowired
    private CounterRepository counterRepository;
    @Autowired
    private CounterExecutiveRepository counterExecutiveRepository;
    

    public String addService(ServiceTypeDTO serviceTypeDTO) {
        // Create a new ServiceType entity
        ServiceType serviceType = new ServiceType();
        serviceType.setStatusOfServiceType("Not assigned");
        serviceType.setTypeOfService(serviceTypeDTO.getTypeOfService());

        // Create a list of Service entities
        List<com.majorProject.entity.Service> services = new ArrayList<>();
        for (ServiceDTO serviceDTO : serviceTypeDTO.getServices()) {
            com.majorProject.entity.Service service = new com.majorProject.entity.Service();
            service.setServiceName(serviceDTO.getServiceName());
            service.setStatusOfService(serviceDTO.getStatusOfService());
            service.setServiceType(serviceType);
            services.add(service);
        }

        // Set the list of services to the ServiceType entity
        serviceType.setServices(services);
        
        serviceRepository.saveAll(services);

        // Save the ServiceType entity with its associated Services
        serviceTypeRepository.save(serviceType);

        return "Servies added successfully!";
    }

	public List<ServiceType> getServicesTypes() {
		List<ServiceType>st = serviceTypeRepository.fetchAllNotAssigned("Not assigned");
		for(ServiceType s : st) {
			System.out.println(s.getTypeOfService());
		}
		return st;
	}
	
//	public String assignCounter(CounterDTO counterDTO) {
//		return "counter is assignes";
//	}
	
	@Transactional
	public String assignCounter(CounterDTO counterDTO) {
        Optional<ServiceType> serviceType = serviceTypeRepository.findById(counterDTO.getServiceTypeId());
        ServiceType s = serviceType.get();
        
        serviceRepository.updateStatusOfServiceType("assigned" , s.getId());

        CounterExecutive counterExecutive = new CounterExecutive();
        counterExecutive.setName(counterDTO.getCounterExecutiveName());
        counterExecutive.setPassword(counterDTO.getPassword());


        Counter counter = new Counter();
        counter.setServiceType(serviceType.get());
        counter.setCounterExecutive(counterExecutive);

        counterRepository.save(counter);

        return "Counter assigned successfully!";
    }
}
