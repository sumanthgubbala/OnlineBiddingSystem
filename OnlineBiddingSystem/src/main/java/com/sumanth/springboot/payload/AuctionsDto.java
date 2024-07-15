package com.sumanth.springboot.payload;

import java.math.BigDecimal;
import java.time.LocalDateTime;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuctionsDto {
	
	private long id;
	private String title;
	private String description;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private BigDecimal startingPrice;
	private String itemName;
	private LocalDateTime createdAt;
	
	

}
