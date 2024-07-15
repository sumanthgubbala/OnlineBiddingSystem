package com.sumanth.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumanth.springboot.payload.AuctionsDto;
import com.sumanth.springboot.service.AuctionsService;

@RestController
@RequestMapping("/api")
public class AuctionsController {
	
	@Autowired
	private AuctionsService auctionservice;
	
	
	//create auction
	
	@PostMapping("/{userid}/auctions")
	public ResponseEntity<AuctionsDto> createauction(
			@PathVariable(name="userid") long id,
			@RequestBody AuctionsDto auctiondto){
		
		return new ResponseEntity<>(auctionservice.saveAuction(id, auctiondto),HttpStatus.CREATED);
	}
	
	@GetMapping("/{userid}/auctions")
	public ResponseEntity<List<AuctionsDto>> getallauctions(
			@PathVariable(name="userid") long userid
			){
		return new ResponseEntity<>(auctionservice.getallAutions(userid),HttpStatus.OK);
	}
	
	

}
