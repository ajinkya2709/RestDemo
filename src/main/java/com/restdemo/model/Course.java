package com.restdemo.model;

import java.io.Serializable;

public class Course implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6574808935114231275L;
	private String id;
	private String name;
	private Integer period;
	private Double fees;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public Double getFees() {
		return fees;
	}

	public void setFees(Double fees) {
		this.fees = fees;
	}
	
	@Override
	public String toString() {
		return id + name + period + fees;
	}

}
