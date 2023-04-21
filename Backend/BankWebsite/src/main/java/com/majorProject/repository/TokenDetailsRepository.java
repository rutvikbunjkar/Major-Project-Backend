package com.majorProject.repository;
import java.util.List;
import java.util.Queue;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.majorProject.entity.TokenDetails;

public interface TokenDetailsRepository extends JpaRepository<TokenDetails, Integer>{

	@Query("select t from TokenDetails t where t.service.serviceType.id=?1 order by t.tokenGenerationTime asc")
	List<TokenDetails> findByServiceId(Integer serviceId);
    
}
