package com.sumanth.springboot.service;

import java.util.List;

import com.sumanth.springboot.payload.AuctionsDto;

public interface AuctionsService {
	
	public AuctionsDto saveAuction(long userid,AuctionsDto auctiondto);

	public List<AuctionsDto> getallAutions(long userid);
}
