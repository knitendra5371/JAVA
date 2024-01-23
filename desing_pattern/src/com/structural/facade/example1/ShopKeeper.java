package com.structural.facade.example1;

public class ShopKeeper {
    private Mobile iphone;
    private Mobile samsung;
    private Mobile blackberry;

    public ShopKeeper(){
        iphone= new Iphone();
        samsung=new Samsung();
        blackberry=new Blackberry();
    }
    public void iphoneSale(){ //here we are encapsulate the methods i.e. we are calling some methods internally
        iphone.modelNo();
        iphone.price();
    }
    public void samsungSale(){
        samsung.modelNo();
        samsung.price();
    }
    public void blackberrySale(){
        blackberry.modelNo();
        blackberry.price();
    }
}
