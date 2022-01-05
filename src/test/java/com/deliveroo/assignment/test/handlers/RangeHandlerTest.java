package com.deliveroo.assignment.test.handlers;

import com.deliveroo.assignment.exception.WrongOrderParsingException;
import com.deliveroo.assignment.handlers.RangeHandler;
import com.deliveroo.assignment.test.utils.TestConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class RangeHandlerTest {

    private static RangeHandler handler;
    private static String cronField;

    @BeforeAll
    public static void setup() {
        handler = new RangeHandler(null);
        cronField = "1-10";
    }


    @Test
    public void testHappyCase() {
        String result = handler.handle(cronField, TestConstants.MASTER_DATA);
        Assertions.assertEquals("1 2 3 4 5 6 7 8 9 10", result);
    }

    @Test
    public void testNegative() {
        String result = handler.handle("1/2/3", TestConstants.MASTER_DATA);
        Assertions.assertEquals(TestConstants.PARSING_ABILITY_NOT_EXISTS, result);
    }

    @Test
    public void testWrongOrder() {
        Assertions.assertThrows(WrongOrderParsingException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                handler.handle("3-1", TestConstants.MASTER_DATA);
            }
        });
    }
}
