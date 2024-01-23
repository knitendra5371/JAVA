package com.asyncwork.services.impl;

import com.asyncwork.dto.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentService {
    public void processPayment(Order order) throws InterruptedException {
        log.info("initiate payment for order => "+order.getProductId());
        Thread.sleep(4000);
        log.info("completed payment for order => "+order.getProductId());
    }
}
