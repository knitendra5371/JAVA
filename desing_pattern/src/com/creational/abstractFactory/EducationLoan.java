package com.creational.abstractFactory;

public class EducationLoan extends Loan{

	/* (non-Javadoc)
	 * @see com.creational.abstractFactory.Loan#getInterestRate(double)
	 */
	@Override
	void getInterestRate(double rate) {
		// TODO Auto-generated method stub
		this.rate=rate;
	}

}
