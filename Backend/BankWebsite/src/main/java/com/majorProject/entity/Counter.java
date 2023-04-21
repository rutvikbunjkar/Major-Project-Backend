package com.majorProject.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "counter")
public class Counter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "counter_id")
    private int counterId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_type_id", referencedColumnName = "id")
    private ServiceType serviceType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "counter_executive_id", referencedColumnName = "counter_executive_id")
    private CounterExecutive counterExecutive;

    @OneToOne(mappedBy = "counter")
    private TokenQueue tokenQueue;

	public int getCounterId() {
		return counterId;
	}

	public void setCounterId(int counterId) {
		this.counterId = counterId;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public CounterExecutive getCounterExecutive() {
		return counterExecutive;
	}

	public void setCounterExecutive(CounterExecutive counterExecutive) {
		this.counterExecutive = counterExecutive;
	}

	public TokenQueue getTokenQueue() {
		return tokenQueue;
	}

	public void setTokenQueue(TokenQueue tokenQueue) {
		this.tokenQueue = tokenQueue;
	}
    
    

    
}
