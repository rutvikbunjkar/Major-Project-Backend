package com.majorProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.majorProject.entity.TransactionBlockStorage;

public interface BlockChainRepository extends JpaRepository<TransactionBlockStorage, Integer>{
	
	@Query("select t from TransactionBlockStorage t where t.publicKey=?1 and t.privateKey=?2 ")
	public Optional<TransactionBlockStorage> findByPublicNPrivate (String publicKey, String privateKey);

}
