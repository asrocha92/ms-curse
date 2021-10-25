package com.treiner.hrpayroll.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.treiner.hrpayroll.entities.Payment;
import com.treiner.hrpayroll.entities.Work;

@Service 
public class PaymentService {

	@Value("${hr-worker.host}")
	private String workerHost;
	
	@Autowired
	private RestTemplate restTemplate;
	 
	public Payment getPayment(long idWork, int days) {
		
		System.err.println("aqui" + workerHost);
	
		Map<String, String> params = new HashMap<>();
		params.put("id", ""+idWork);
		
		Work worket = restTemplate.getForObject(workerHost + "/workers/get/{id}", Work.class, params);
		
		return new Payment(worket.getName(), worket.getDailyIncome(), 21);
	}
}
