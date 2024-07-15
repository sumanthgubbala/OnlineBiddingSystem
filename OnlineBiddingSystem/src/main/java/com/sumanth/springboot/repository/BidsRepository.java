package com.sumanth.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sumanth.springboot.model.Bids;

public interface BidsRepository extends JpaRepository<Bids, Long> {

}
