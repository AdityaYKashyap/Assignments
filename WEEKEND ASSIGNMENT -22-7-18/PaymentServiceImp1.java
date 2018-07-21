package mobilePayment.service;

import mobilePayment.dao.PaymentDao;
import mobilePayment.dao.PaymentDaoImp1;
import mobilePayment.exception.PaymentException;
import mobilePayment.util.Message;

public class PaymentServiceImp1 implements PaymentService {
	private PaymentDao pDao;
	
	
	public PaymentServiceImp1() {
		// TODO Auto-generated constructor stub
		pDao = new PaymentDaoImp1();
	}

	@Override
	public boolean authenticate(String mob, String pass) {
		// TODO Auto-generated method stub
		return pDao.authenticate(mob,pass);
	}

	@Override
	public void setAmount() {
		// TODO Auto-generated method stub
		pDao.setAmount();
	}

	@Override
	public void payAmount(double amount) throws PaymentException {
		// TODO Auto-generated method stub
		isAmountNegative(amount);
		pDao.payAmount(amount);
	}

	@Override
	public String paymentStatus() {
		// TODO Auto-generated method stub
		return pDao.paymentStatus();
	}

	@Override
	public double getAmount() {
		// TODO Auto-generated method stub
		return pDao.getAmount();
	}

	private boolean isAmountNegative(double amount) throws PaymentException {
		if(amount<0) {
			throw new PaymentException(Message.NEGATIVE_VALUE);
		}
		return true;
	}
}
