package com.deliveroo.assignment.test.parser;

import com.deliveroo.assignment.handlers.*;
import com.deliveroo.assignment.parser.GenericParser;
import com.deliveroo.assignment.utils.CronUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;


public class GenericParserTest {
    private static GenericParser genericParser;

    @BeforeAll
    public static void setup() {
        SimpleValueHandler simpleValueHandler = new SimpleValueHandler(null);
        StepHandler stepHandler = new StepHandler(simpleValueHandler);
        RangeHandler rangeHandler = new RangeHandler(stepHandler);
        MultipleValuesHandler multipleValuesHandler = new MultipleValuesHandler(rangeHandler);
        ArbitValueHandler arbitValueHandler = new ArbitValueHandler(multipleValuesHandler);
        AnyValueHandler anyValueHandler = new AnyValueHandler(arbitValueHandler);

        genericParser = new GenericParser(anyValueHandler, CronUtilities.populateMasterData());
    }

    @Test
    public void test1() {
        String[] cronExpression = {"*/15", "0", "1,15", "*", "1-5"};
        String expectedResult = "[0 15 30 45, 0, 1 15, 1 2 3 4 5 6 7 8 9 10 11 12, 1 2 3 4 5]";
        List<String> result = genericParser.parseCronExpression(cronExpression);
        Assertions.assertEquals(expectedResult, result.toString());
    }

    @Test
    public void test2() {
        String[] cronExpression = {"*/15", "1/2", "1,15", "*", "1-5"};
        String expectedResult = "[0 15 30 45, 1 3 5 7 9 11 13 15 17 19 21 23, 1 15, 1 2 3 4 5 6 7 8 9 10 11 12, 1 2 3 4 5]";
        List<String> result = genericParser.parseCronExpression(cronExpression);
        Assertions.assertEquals(expectedResult, result.toString());
    }

    @Test
    public void test3() {
        String[] cronExpression = {"1,4,5", "0", "1-5", "*", "1/2"};
        String expectedResult = "[1 4 5, 0, 1 2 3 4 5, 1 2 3 4 5 6 7 8 9 10 11 12, 1 3 5]";
        List<String> result = genericParser.parseCronExpression(cronExpression);
        Assertions.assertEquals(expectedResult, result.toString());
    }

    @Test
    public void test4() {
        String[] cronExpression = {"5", "12", "*", "*", "*"};
        String expectedResult = "[5, 12, 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31, 1 2 3 4 5 6 7 8 9 10 11 12, 0 1 2 3 4 5 6]";
        List<String> result = genericParser.parseCronExpression(cronExpression);
        Assertions.assertEquals(expectedResult, result.toString());
    }

    @Test
    public void test5() {
        String[] cronExpression = {"*/15", "22", "*", "*", "*"};
        String expectedResult = "[0 15 30 45, 22, 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31, 1 2 3 4 5 6 7 8 9 10 11 12, 0 1 2 3 4 5 6]";
        List<String> result = genericParser.parseCronExpression(cronExpression);
        Assertions.assertEquals(expectedResult, result.toString());
    }

}
