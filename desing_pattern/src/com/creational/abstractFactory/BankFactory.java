package com.creational.abstractFactory;

public class BankFactory implements AbstractFactory{
	/* (non-Javadoc)
	 * @see com.creational.abstractFactory.AbstractFactory#getLoan(java.lang.String)
	 */
	@Override
	public Loan getLoan(String loanName) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Bank getBank(String bankName) {
		
		Bank bank = null;
		if (bankName.equalsIgnoreCase("HDFC BANK")) {
			bank = new HDFC();
		} else if (bankName.equalsIgnoreCase("SBI BANK")) {
			bank = new SBI();
		} else if (bankName.equalsIgnoreCase("ICICI BANK")) {
			bank = new ICICI();
		}

		return bank;
	}
}
