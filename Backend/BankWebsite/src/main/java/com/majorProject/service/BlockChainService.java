package com.majorProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.majorProject.entity.TransactionBlockStorage;
import com.majorProject.model.TransactionBlockData;
import com.majorProject.repository.BlockChainRepository;

@Service
public class BlockChainService {
	
	@Autowired
	BlockChainRepository blockChainRepository;
	
	public String saveBlock(TransactionBlockStorage t) {
		
		blockChainRepository.save(t);
		
		return "block added successfully";
	}
	
	public TransactionBlockStorage getBlock(TransactionBlockData t) {
		
		TransactionBlockStorage t1 = blockChainRepository.findByPublicNPrivate(t.getPublicKey(), t.getPrivateKey()).get();
		
		return t1;
		
	}

}
