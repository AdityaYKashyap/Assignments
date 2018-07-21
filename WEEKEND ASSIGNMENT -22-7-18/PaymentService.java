package mobilePayment.service;

import mobilePayment.exception.PaymentException;

public interface PaymentService {

	boolean authenticate(String mob, String pass);

	void setAmount();

	void payAmount(double amount) throws PaymentException;

	String paymentStatus();

	double getAmount();
	
}
