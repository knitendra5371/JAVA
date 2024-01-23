package com.creational.abstractFactory;

public class SBI implements Bank{

	private String bankName;
	
	SBI(){
		bankName="SBI BANK";
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
