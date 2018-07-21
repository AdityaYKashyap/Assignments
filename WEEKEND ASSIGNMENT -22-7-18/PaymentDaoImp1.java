package mobilePayment.dao;

import java.util.regex.*;
import java.util.Random;

public class PaymentDaoImp1 implements PaymentDao {
	private double bill;
	
	@Override
	public boolean authenticate(String mob, String pass) {
		// TODO Auto-generated method stub
		boolean val = (Pattern.matches("^[7-9]\\d{9}$", mob) && pass.equals(mob.substring(mob.length()-4, mob.length())+"qwerty"));
		return val;
	}

	@Override
	public void setAmount() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		bill = (rand.nextInt(50)+100)*10;
	}

	@Override
	public void payAmount(double amount) {
		// TODO Auto-generated method stub
		bill -= amount;
	}

	@Override
	public String paymentStatus() {
		// TODO Auto-generated method stub
		if (bill < 0)
			return "Credit";
		else 
			return "Debit";
	}

	@Override
	public double getAmount() {
		// TODO Auto-generated method stub
		if(bill<0)
			return -bill;
		else 
			return bill;
	}

}
