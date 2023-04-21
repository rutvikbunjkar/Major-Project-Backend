package com.majorProject.model;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Dates {

	@Temporal(TemporalType.TIME)
    @DateTimeFormat(style = "yyyy/MM/dd hh:mm:ss a")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy/MM/dd hh:mm:ss a")
	private Date datefrom;
	
	@Temporal(TemporalType.TIME)
    @DateTimeFormat(style = "yyyy/MM/dd hh:mm:ss a")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy/MM/dd hh:mm:ss a")
	private Date dateto;
	
	private int customerid;
	
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public Date getDatefrom() {
		return datefrom;
	}
	public void setDatefrom(Date datefrom) {
		this.datefrom = datefrom;
	}
	public Date getDateto() {
		return dateto;
	}
	public void setDateto(Date dateto) {
		this.dateto = dateto;
	}
	
}
