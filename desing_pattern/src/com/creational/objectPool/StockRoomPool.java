package com.creational.objectPool;

public class StockRoomPool extends ObjectPool<StockRoom>{
    private int stockNumber= 1234;
    public StockRoomPool(int size) {
        super(size);
    }

    @Override
    public StockRoom create() {
        StockRoom stockRoom = new StockRoom(stockNumber);
        System.out.println("creating instance with instance Id: "+stockRoom.getInstanceId());
        return stockRoom;
    }
}
