package com.sumanth.springboot.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name="auctions")
public class Auctions {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(name = "description") 
    private String description;
	
	@Column(nullable = false)
	private LocalDateTime startTime;
	
	@Column(nullable = false)
	private LocalDateTime endTime;
	
	
	@Column(nullable = false)
	private BigDecimal startingPrice;
	
	@Column(nullable = false)
	private String itemName;
	
	
	@Column(updatable = false)
	private LocalDateTime createdAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;



	@PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
	
	  @Column(nullable = false)
	    public String getStartTimeFormatted() {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
	        return startTime.format(formatter);
	    }
	    
	    // Custom date format for endTime
	    @Column(nullable = false)
	    public String getEndTimeFormatted() {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
	        return endTime.format(formatter);
	    }
	

	
	

}
