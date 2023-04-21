package com.majorProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.majorProject.entity.TransactionBlockStorage;
import com.majorProject.model.TransactionBlockData;
import com.majorProject.service.BlockChainService;

@RestController
@CrossOrigin
public class BlockChainController {
	
	@Autowired
	BlockChainService blockChainService;
	
	@PostMapping("/saveBlock")
	public String saveBlock(@RequestBody TransactionBlockStorage t) {
		
		String msg = blockChainService.saveBlock(t);
		
		return msg;
	}
	
	@GetMapping("/getBlock")
	public TransactionBlockStorage getBlock(@RequestBody TransactionBlockData t) {
		
		TransactionBlockStorage t1 = blockChainService.getBlock(t);
		
		return t1;
	}
	 
}
