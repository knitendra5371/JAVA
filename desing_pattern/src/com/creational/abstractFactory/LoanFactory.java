package com.creational.abstractFactory;

public class LoanFactory implements AbstractFactory{
	/* (non-Javadoc)
	 * @see com.creational.abstractFactory.AbstractFactory#getBank(java.lang.String)
	 */
	@Override
	public Bank getBank(String bankName) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Loan getLoan(String loanName) {
		Loan loan = null;
		if (loanName.equalsIgnoreCase("HOME LOAN")) {
			loan = new HomeLoan();
		} else if (loanName.equalsIgnoreCase("BUSINESS LOAN")) {
			loan = new BusinessLoan();
		} else if (loanName.equalsIgnoreCase("EDUCATION LOAN")) {
			loan = new EducationLoan();
		}

		return loan;
	}
}
