package com.deliveroo.assignment.test.handlers;

import com.deliveroo.assignment.handlers.MultipleValuesHandler;
import com.deliveroo.assignment.test.utils.TestConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class MultipleValuesHandlerTest {

    private static MultipleValuesHandler handler;
    private static String cronField;

    @BeforeAll
    public static void setup() {
        handler = new MultipleValuesHandler(null);
        cronField = "1,2,3";
    }


    @Test
    public void testHappyCase() {
        String result = handler.handle(cronField, TestConstants.MASTER_DATA);
        Assertions.assertEquals("1 2 3", result);
    }

    @Test
    public void testNegative() {
        String result = handler.handle("1/2/3", TestConstants.MASTER_DATA);
        Assertions.assertEquals(TestConstants.PARSING_ABILITY_NOT_EXISTS, result);
    }


}
