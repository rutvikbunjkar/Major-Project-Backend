package com.majorProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.majorProject.entity.ServiceType;

public interface ServiceTypeRepository extends JpaRepository<ServiceType, Integer> {
	
	@Query("select st from ServiceType st where st.statusOfServiceType=?1")
	List<ServiceType> fetchAllNotAssigned(String s);
}
