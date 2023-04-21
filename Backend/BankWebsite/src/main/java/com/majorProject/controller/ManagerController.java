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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.majorProject.entity.Counter;
import com.majorProject.entity.Service;
import com.majorProject.entity.ServiceType;
import com.majorProject.model.CounterDTO;
import com.majorProject.model.ServiceDTO;
import com.majorProject.model.ServiceTypeDTO;
import com.majorProject.service.ManagerService;

@RestController
@CrossOrigin
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @PostMapping(path="/addService")
    public String addService(@RequestBody ServiceTypeDTO serviceTypeDTO) {
        return managerService.addService(serviceTypeDTO);
    }
    
//    @GetMapping(path="/getServicesTypes")
//    public List<ServiceType> getServicesTypes(){
//    	return managerService.getServicesTypes();
//    }
    
    @GetMapping(path="/getServicesTypes")
    public List<ServiceTypeDTO> getServicesTypes(){
        List<ServiceType> serviceTypes = managerService.getServicesTypes();
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
    
    @PostMapping(path="/assignCounter")
    public String assignCounter(@RequestBody CounterDTO counterDTO) {
    	return managerService.assignCounter(counterDTO);
    }


}
