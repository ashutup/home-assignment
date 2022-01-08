package com.deliveroo.assignment.test.handlers;

import com.deliveroo.assignment.handlers.StepHandler;
import com.deliveroo.assignment.test.utils.TestConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StepHandlerTest {

    private static StepHandler handler;
    private static String cronField;

    @BeforeAll
    public static void setup() {
        handler = new StepHandler(null);
        cronField = "1/6";
    }


    @Test
    public void testHappyCase() {
        String result = handler.handle(cronField, TestConstants.getListOfDataSet());
        Assertions.assertEquals("1 7 13 19 25 31 37 43 49 55", result);
    }

    @Test
    public void testNegative() {
        String result = handler.handle("1*3", TestConstants.getListOfDataSet());
        Assertions.assertEquals(TestConstants.PARSING_ABILITY_NOT_EXISTS, result);
    }
}
