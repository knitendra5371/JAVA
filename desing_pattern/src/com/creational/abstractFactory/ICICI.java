package com.creational.abstractFactory;

public class ICICI implements Bank{
	private String bankName;
	
	ICICI(){
		bankName="ICICI BANK";
	}

	/* (non-Javadoc)
	 * @see com.creational.abstractFactory.Bank#getBankName()
	 */
	@Override
	public String getBankName() {
		// TODO Auto-generated method stub
		return bankName;
	}
	
	
}
