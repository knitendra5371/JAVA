package com.asyncwork.services.impl;

import com.asyncwork.dto.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class OrderFulfillmentService {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private PaymentService paymentService;

    /* All Required process */

    /*
    1. Inventory service check order availability
    2. process payment for order
    3. Notify to the user
    4. Assign to vendor
    5. packaging
    6. Assign delivery partner
    7. Assign trailer
    8. Dispatch product
    * */

    public void processOrder(Order order) throws InterruptedException {
        order.setTrackingId(UUID.randomUUID().toString());
        if(inventoryService.checkProductAvailability(order.getProductId())){
            paymentService.processPayment(order);
        }else {
            throw new RuntimeException("Technical issue, Please retry!!");
        }
    }

    @Async("asyncExecutor")
    public void notifyUser(Order order) throws InterruptedException {
        Thread.sleep(4000);
        log.info("Notified to the user => "+Thread.currentThread().getName());
    }

    @Async("asyncExecutor")
    public void assignVendor(Order order) throws InterruptedException {
        Thread.sleep(5000);
        log.info("Assign order to vendor => "+Thread.currentThread().getName());
    }

    @Async("asyncExecutor")
    public void packaging(Order order) throws InterruptedException {
        Thread.sleep(4000);
        log.info("order packaging completed => "+Thread.currentThread().getName());
    }

    @Async("asyncExecutor")
    public void assignDeliveryPartner(Order order) throws InterruptedException {
        Thread.sleep(2000);
        log.info("Delivery partner assigned => "+Thread.currentThread().getName());
    }

    @Async("asyncExecutor")
    public void assignTrailerAndDispatch(Order order) throws InterruptedException {
        Thread.sleep(5000);
        log.info("Trailer assigned and order dispatched => "+Thread.currentThread().getName());
    }
}
