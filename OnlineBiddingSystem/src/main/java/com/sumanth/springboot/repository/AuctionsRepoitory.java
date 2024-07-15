package com.sumanth.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sumanth.springboot.model.Auctions;


public interface AuctionsRepoitory extends JpaRepository<Auctions, Long> {

	List<Auctions> findAllByUserId(long userid);

	

}
