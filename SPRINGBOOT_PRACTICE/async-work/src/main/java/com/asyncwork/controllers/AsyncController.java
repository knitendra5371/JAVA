package com.asyncwork.controllers;

import com.asyncwork.services.impl.AsyncTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/async")
@Slf4j
public class AsyncController {

    @Autowired
    private AsyncTestService service;

    @GetMapping("/test")
    public ResponseEntity<String> asyncTest() throws InterruptedException {
        log.info("**********************************");
        service.secondMethod();
        log.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        service.firstMethod();
        log.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

        return ResponseEntity.ok("done");
    }


}
