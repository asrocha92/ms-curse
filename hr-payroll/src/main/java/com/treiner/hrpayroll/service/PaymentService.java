package com.treiner.hrpayroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treiner.hrpayroll.entities.Payment;
import com.treiner.hrpayroll.entities.Work;
import com.treiner.hrpayroll.feignclients.HrWorkerFeignClients;

@Service 
public class PaymentService {

	@Autowired
	private HrWorkerFeignClients feignClients;
	 
	public Payment getPayment(long idWork, int days) {
		
		Work worket = feignClients.findById(idWork).getBody();
		
		return new Payment(worket.getName(), worket.getDailyIncome(), 21);
	}
}
