package com.creational.objectPool;

public class StockRoomPoolDemo {
    public ObjectPool<StockRoom> pool;
    private void setUp(int size) {
        pool = new StockRoomPool(size);
    }
    private int getSize(){
        return pool.size();
    }
    private void printInstanceId(StockRoom stockRoom){
        System.out.println("Instance Id: "+stockRoom.getInstanceId());
    }
    private void printPoolSize(StockRoomPoolDemo demo){
        System.out.println("Pool size: "+demo.getSize());
    }
    public static void main(String[] args) {
        StockRoomPoolDemo demo = new StockRoomPoolDemo();
        demo.setUp(2);
        demo.printPoolSize(demo);
        StockRoom firstObject = demo.pool.borrowObject();
        System.out.println("Instance Id: "+firstObject.getInstanceId());
        demo.printPoolSize(demo);
        StockRoom secondObject = demo.pool.borrowObject();
        System.out.println("Instance Id: "+secondObject.getInstanceId());
        demo.printPoolSize(demo);

        StockRoom thirdObject = demo.pool.borrowObject();
        System.out.println("Instance Id: "+thirdObject.getInstanceId());

        demo.pool.returnObject(firstObject);
        demo.printPoolSize(demo);




    }
}
