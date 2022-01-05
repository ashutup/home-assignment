package com.deliveroo.assignment.test.handlers;

import com.deliveroo.assignment.handlers.AnyValueHandler;
import com.deliveroo.assignment.test.utils.TestConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AnyValueHandlerTest {
    private static AnyValueHandler handler;
    private static String cronField;

    @BeforeAll
    public static void setup() {
        handler = new AnyValueHandler(null);
        cronField = "*";
    }

    @Test
    public void testHappyCase() {
        String result = handler.handle(cronField, TestConstants.MASTER_DATA);
        Assertions.assertEquals("0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59", result);
    }

    @Test
    public void testNegative() {
        String result = handler.handle("1/2/3", TestConstants.MASTER_DATA);
        Assertions.assertEquals(TestConstants.PARSING_ABILITY_NOT_EXISTS, result);
    }
}
