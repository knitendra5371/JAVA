package com.structural.adapter;
/*
this is a adapter class
 */
public class BankCustomer extends BankDetails implements CreaditCard{
    String accHolderName="Nitendra kumar";
    String bankName="SBI";
    int accNumber=123456789;
    @Override
    public void giveBabkDetails() {

        BankDetails bankDetails = new BankDetails();
        bankDetails.setBankName(bankName);
        bankDetails.setAccHolderName(accHolderName);
        bankDetails.setAccNumber(accNumber);
    }

    @Override
    public void getCreditCard() {
        System.out.println("The Account number "+ accNumber + " of "+accHolderName+" in "
                +bankName+ " bank is valid and authenticated for issuing the credit card");
    }
}
