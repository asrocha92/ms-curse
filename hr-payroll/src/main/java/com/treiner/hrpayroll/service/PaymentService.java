package com.treiner.hrpayroll.service;

import org.springframework.stereotype.Service;

import com.treiner.hrpayroll.entities.Payment;

@Service 
public class PaymentService {

	 
	public Payment getPayment(long idWork, int days) {
		return new Payment("Alex", 100.0, 21);
	}
}
