package com.majorProject.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "token_details")
public class TokenDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "token_id")
    private int tokenId;

    @Column(name = "expected_wait_time")
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(style = "hh:mm")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="hh:mm")
    private Date expectedWaitTime;
    
    @Column(name = "token_generation_time")
    @CreationTimestamp
    @DateTimeFormat(style = "hh:mm")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="hh:mm")
    private Date tokenGenerationTime;

    @Column(name = "status")
    private String status;

    @OneToOne
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    private Service service;
   
    @ManyToOne
    @JoinColumn(name = "queue_id", referencedColumnName = "queue_id")
    private TokenQueue tokenQueue;

    public int getTokenId() {
		return tokenId;
	}

	public void setTokenId(int tokenId) {
		this.tokenId = tokenId;
	}

	public Date getExpectedWaitTime() {
		return expectedWaitTime;
	}

	public void setExpectedWaitTime(Date expectedWaitTime) {
		this.expectedWaitTime = expectedWaitTime;
	}

	public Date getTokenGenerationTime() {
		return tokenGenerationTime;
	}

	public void setTokenGenerationTime(Date tokenGenerationTime) {
		this.tokenGenerationTime = tokenGenerationTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public TokenQueue getTokenQueue() {
		return tokenQueue;
	}

	public void setTokenQueue(TokenQueue tokenQueue) {
		this.tokenQueue = tokenQueue;
	}
    

}

