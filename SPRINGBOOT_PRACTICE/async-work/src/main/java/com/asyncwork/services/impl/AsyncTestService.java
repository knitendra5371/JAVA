package com.asyncwork.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AsyncTestService {


    @Async("asyncExecutor")
    public void firstMethod() throws InterruptedException {
        log.info("first method started............"+Thread.currentThread().getName());
        Thread.sleep(50000);
        log.info("first method ended................"+Thread.currentThread().getName());
    }

    //    @Async("asyncExecutor")
    public void secondMethod(){
//        Thread.sleep(10000);
        log.info("second method started............"+Thread.currentThread().getName());

    }
}
