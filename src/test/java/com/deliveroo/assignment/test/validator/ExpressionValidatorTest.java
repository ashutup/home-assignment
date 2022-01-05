package com.deliveroo.assignment.test.validator;

import com.deliveroo.assignment.validator.ValidationUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ExpressionValidatorTest {

    private static Properties configuration;

    @BeforeAll
    public static void setup() {
        configuration = new Properties();
        InputStream inputStream = ExpressionValidatorTest.class
                .getClassLoader()
                .getResourceAsStream("application-test.properties");
        try {
            configuration.load(inputStream);
            assert inputStream != null;
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testAllWrongFields() {
        String[] args = {"2^3", "6899", "977", "2080", "777", "doSomething"};
        boolean result = ValidationUtils.isCronExpressionValid(args, configuration);

        Assertions.assertFalse(result);
    }

    @Test
    public void testAllWrongFields4() {
        String[] args = {"2///", "6899", "977", "2080", "777", "doSomething"};
        boolean result = ValidationUtils.isCronExpressionValid(args, configuration);

        Assertions.assertFalse(result);
    }

    @Test
    public void testAllWrongFields1() {
        String[] args = {"2---3", "6899", "977", "2080", "777", "doSomething"};
        boolean result = ValidationUtils.isCronExpressionValid(args, configuration);

        Assertions.assertFalse(result);
    }

    @Test
    public void testAllWrongFields2() {
        String[] args = {"********", "*", "12", "10", "2-5", "doSomething"};
        boolean result = ValidationUtils.isCronExpressionValid(args, configuration);

        Assertions.assertFalse(result);
    }

    @Test
    public void testAllWrongFields3() {
        String[] args = {"*", "*", "100", "*", "*", "doSomething"};
        boolean result = ValidationUtils.isCronExpressionValid(args, configuration);

        Assertions.assertFalse(result);
    }

    @Test
    public void testForAllValid() {
        String[] args = {"1/10", "*", "12", "10", "2-5", "doSomething"};
        boolean result = ValidationUtils.isCronExpressionValid(args, configuration);

        Assertions.assertTrue(result);
    }
}
