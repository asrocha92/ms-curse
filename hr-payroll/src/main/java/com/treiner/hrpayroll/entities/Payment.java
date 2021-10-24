package com.treiner.hrpayroll.entities;

import java.io.Serializable;

public class Payment implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String name;
	
	private Double dailyIncome;
	
	private int days;
	
	private Double total;
	
	
	public Payment() {}

	public Payment(String name, Double dailyIncome, int days) {
		this.name = name;
		this.dailyIncome = dailyIncome;
		this.days = days;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getDailyIncome() {
		return dailyIncome;
	}


	public void setDailyIncome(Double dailyIncome) {
		this.dailyIncome = dailyIncome;
	}


	public int getDays() {
		return days;
	}


	public void setDays(int days) {
		this.days = days;
	}
	
	public void setTotal(Double total) {
		this.total = total;
	}
	
	public Double getTotal() {
		return days * dailyIncome;
	}

	
	
}
