package mobilePayment.dao;

public interface PaymentDao {

	boolean authenticate(String mob, String pass);

	void setAmount();

	void payAmount(double amount);

	String paymentStatus();

	double getAmount();
	
}
