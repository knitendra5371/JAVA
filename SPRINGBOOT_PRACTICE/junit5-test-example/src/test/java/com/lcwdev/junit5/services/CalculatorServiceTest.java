package com.lcwdev.junit5.services;

import org.junit.jupiter.api.*;

public class CalculatorServiceTest {


    @BeforeAll
    public static void init(){
//        System.out.println("this is a single time logic");
        System.out.println("It will execute before all test cases, only once");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("it will execute before each test case => beforeEach");
    }

    @Test
//    @Disabled  // when we want to disable test class then we do disable that test method
    public void addTwoNumbersTest(){
        System.out.println("test for addTwoNumbersTest");
        int actualResult = CalculatorService.addTwoNumbers(12,45);
        int expectedResult = 57;  // a+b

        Assertions.assertEquals(expectedResult,actualResult,"Test fail !!");
    }

    // test method of sumAnyNumbers
    @Test()
//    @Timeout(value=2000) // will check implementation after some time
    public void sumAnyNumbersTest() throws InterruptedException {
        System.out.println("test for sumAnyNumbersTest");
        Thread.sleep(4000);
        int actual = CalculatorService.sumAnyNumbers(1,2,3,4,5);
        int expected = 15;
        Assertions.assertEquals(expected,actual);
    }

    @AfterEach
    public void afterEach(){
        System.out.println("it will execute after each test case => afterEach");
    }

    @AfterAll
    public static void cleanup(){
        System.out.println("it will execute after all test cases, only once");
    }
}
