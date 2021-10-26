package com.treiner.hrpayroll.resource;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treiner.hrpayroll.entities.Payment;
import com.treiner.hrpayroll.service.PaymentService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {
	
	private static final String PAYMENT_SERVICE = "paymentService";
	
	@Autowired
	private PaymentService service;
	
	@CircuitBreaker(fallbackMethod = "orderFallback", name = PAYMENT_SERVICE)
	@GetMapping(value = "/idworker/{idWorker}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long idWorker, @PathVariable Integer days) {
		Payment payment =  service.getPayment(idWorker, days);
		return ResponseEntity.ok(payment);
	}
	
	public ResponseEntity<String> orderFallback(Exception e){
        return ResponseEntity.status(400).body("Serviço indisponível");

    }
	
	
}
