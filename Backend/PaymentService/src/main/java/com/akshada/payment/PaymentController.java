package com.akshada.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class PaymentController {
	
	@Autowired
	private PaymentService payment; 
	
	@GetMapping("/createTransaction/{amount}")
	public TransactionDetails createTransaction(@PathVariable double amount) {
		return payment.createTransaction(amount);
	}

}
