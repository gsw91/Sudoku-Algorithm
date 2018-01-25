package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void testGetLastLog() {
        //Given
        Logger logger = Logger.getInstance();
        //When
        logger.log("Logger test");
        String result = logger.getLastLog();
        //Then
        Assert.assertEquals("Logger test", result);
    }
}
