package com.log4j2demo.testing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4j2Test {
    private static final Logger logger = LoggerFactory.getLogger(Log4j2Test.class);
    public static void main(String[] args) {
        /*
        * All these logs will be write in app.log file, File path is mention in log4j2.xml file
        * */
        logger.info("info..........");
        logger.debug("debug........");
        logger.error("error.........");
    }
}
