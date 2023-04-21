package com.majorProject.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "token_queue")
public class TokenQueue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "queue_id")
    private int queueId;

    @ManyToOne
    @JoinColumn(name = "counter_id", referencedColumnName = "counter_id")
    private Counter counter;

    @OneToMany(mappedBy = "tokenQueue")
    private List<TokenDetails> tokenDetails;

	public int getQueueId() {
		return queueId;
	}

	public void setQueueId(int queueId) {
		this.queueId = queueId;
	}

	public Counter getCounter() {
		return counter;
	}

	public void setCounter(Counter counter) {
		this.counter = counter;
	}

	public List<TokenDetails> getTokenDetails() {
		return tokenDetails;
	}

	public void setTokenDetails(List<TokenDetails> tokenDetails) {
		this.tokenDetails = tokenDetails;
	}

    
}
