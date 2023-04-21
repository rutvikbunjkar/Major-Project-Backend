package com.majorProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.majorProject.entity.Service;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
	
	@Modifying
	@Query("update ServiceType st set st.statusOfServiceType=?1 where st.id=?2")
	void updateStatusOfServiceType(String string, int id);

}
