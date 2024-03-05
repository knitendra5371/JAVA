package com.behavioral.template_pattern.example2;

public abstract class OrderProcessTemplate {
    boolean isGiftWrap;
    protected abstract void selectProduct();
    protected abstract void makePayment();

    private void packProduct(){
        if(isGiftWrap){
            System.out.println("Gift wrapping Product");
        }else{
            System.out.println("Simply Packed Product");
        }
    }

    protected abstract void deliverProduct();

    public final void processOrder(){
        selectProduct();
        makePayment();
        packProduct();
        deliverProduct();
    }
}
