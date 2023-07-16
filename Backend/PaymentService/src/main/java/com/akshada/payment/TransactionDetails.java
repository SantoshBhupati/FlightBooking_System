package com.akshada.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDetails {
	
	private String orderId;
	private String currency;
	private Integer amount;
	private String key;

}
