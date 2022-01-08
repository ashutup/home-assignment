package com.deliveroo.assignment.test.handlers;

import com.deliveroo.assignment.handlers.SimpleValueHandler;
import com.deliveroo.assignment.test.utils.TestConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SimpleValueHandlerTest {

    private static SimpleValueHandler handler;
    private static String cronField;

    @BeforeAll
    public static void setup() {
        handler = new SimpleValueHandler(null);
        cronField = "9";
    }


    @Test
    public void testHappyCase() {
        String result = handler.handle(cronField, TestConstants.getListOfDataSet());
        Assertions.assertEquals("9", result);
    }

    @Test
    public void testNegative() {
        String result = handler.handle("1/2/3", TestConstants.getListOfDataSet());
        Assertions.assertEquals(TestConstants.PARSING_ABILITY_NOT_EXISTS, result);
    }
}
