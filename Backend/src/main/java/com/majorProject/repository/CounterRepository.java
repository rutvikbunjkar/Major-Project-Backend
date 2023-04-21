package com.majorProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.majorProject.entity.Counter;

public interface CounterRepository extends JpaRepository<Counter, Integer> {

	@Query("select c.serviceType.id from Counter c where c.counterId=?1")
	Integer findByCounterId(Integer counterId);

	
	@Query("select c.counterId from Counter c where c.counterExecutive.counterExecutiveId =?1")
	public Integer findByCounterExecutiveId(Integer cEid);
}
