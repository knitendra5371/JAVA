package com.creational.abstractFactory;

public class HDFC implements Bank{

	private String bankName;
	
	HDFC(){
		bankName="HDFC BANK";
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
