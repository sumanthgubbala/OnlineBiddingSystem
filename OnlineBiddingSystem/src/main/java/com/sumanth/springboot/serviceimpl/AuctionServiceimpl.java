package com.sumanth.springboot.serviceimpl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.sumanth.springboot.exceptiom.UsersNotFound;
import com.sumanth.springboot.model.Auctions;
import com.sumanth.springboot.model.Users;
import com.sumanth.springboot.payload.AuctionsDto;
import com.sumanth.springboot.repository.AuctionsRepoitory;
import com.sumanth.springboot.repository.UsersRepository;
import com.sumanth.springboot.service.AuctionsService;

@Service
public class AuctionServiceimpl implements AuctionsService {
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Autowired
	private UsersRepository userrepo;
	
	@Autowired
	private AuctionsRepoitory auctionrepo;
	

	@Override
	public AuctionsDto saveAuction(long userid, AuctionsDto auctiondto) {
		
		Users user=userrepo.findById(userid).orElseThrow(
				() -> new UsersNotFound(String.format("user id %d not found", userid)));
			
		
		Auctions auction=modelmapper.map(auctiondto, Auctions.class);
		auction.setUser(user);
		
		Auctions savedauction =auctionrepo.save(auction);
		
		return modelmapper.map(savedauction, AuctionsDto.class);
	}

	@Override
	public List<AuctionsDto> getallAutions(long userid) {
		userrepo.findById(userid).orElseThrow(
				() -> new UsersNotFound(String.format("user id %d not found", userid)));
		List<Auctions> users=auctionrepo.findAllByUserId(userid);
		return users.stream().map(
				user -> modelmapper.map(user, AuctionsDto.class)
				).collect(Collectors.toList());
	}

}
