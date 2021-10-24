package com.treiner.hrpayroll.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treiner.hrpayroll.entities.Payment;
import com.treiner.hrpayroll.service.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {
	
	@Autowired
	private PaymentService service;
	
	
	@GetMapping(value = "/idworker/{idWorker}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long idWorker, @PathVariable Integer days) {
		Payment payment =  service.getPayment(idWorker, days);
		return ResponseEntity.ok(payment);
	}
}
