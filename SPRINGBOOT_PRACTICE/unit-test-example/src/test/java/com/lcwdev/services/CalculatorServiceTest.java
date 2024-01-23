package com.lcwdev.services;

import org.junit.*;

import java.util.Date;


/*
* this is a junit4 example
* Note:- some annotations and classes has been changed in junit5
* */
public class CalculatorServiceTest {

    @BeforeClass
    public static void init(){
        System.out.println("Before all test cases");
        System.out.println("Before test cases: "+ new Date());
        // may be need create DB connection / open file
    }

    @Before // when we need to set the counter before each test case
    public void beforeEach(){
        System.out.println("before each test case");
    }

    // test method of addTwoNumbers
    @Test
    public void addTwoNumbersTest(){
        System.out.println("test for addTwoNumbersTest");
        int actualResult = CalculatorService.addTwoNumbers(12,45);
        int expectedResult = 57;  // a+b

        Assert.assertEquals(expectedResult,actualResult);
    }

    // test method of sumAnyNumbers
    @Test(timeout = 2000)
    public void sumAnyNumbersTest() throws InterruptedException {
        System.out.println("test for sumAnyNumbersTest");
//        Thread.sleep(3000);
        int actual = CalculatorService.sumAnyNumbers(1,2,3,4,5);
        int expected = 15;
        Assert.assertEquals(expected,actual);
    }

    @After
    public void AfterEach(){
        System.out.println("after each test case");
    }

    @AfterClass
    public static void cleanup(){
        System.out.println("After all test cases");
        System.out.println("After test cases: "+ new Date());
        // may be need close DB connection /  file
    }
}
