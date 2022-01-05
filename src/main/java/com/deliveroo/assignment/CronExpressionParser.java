package com.deliveroo.assignment;

import com.deliveroo.assignment.handlers.*;
import com.deliveroo.assignment.parser.GenericParser;
import org.apache.commons.lang3.ArrayUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static com.deliveroo.assignment.utils.Constants.INVALID_CRON_EXPRESSION;
import static com.deliveroo.assignment.utils.Constants.cronFieldPositions;
import static com.deliveroo.assignment.utils.CronUtilities.*;
import static com.deliveroo.assignment.validator.ValidationUtils.isCronExpressionValid;
import static com.deliveroo.assignment.validator.ValidationUtils.validateInput;

/**
 * Main class which takes cron expression in one argument and prints all denoted values for each field.<br>
 * <p>
 * This main class does the following pieces of work.<br>
 * <p>
 * 1. Validates the provided cron expression<br>
 * 2. Creates the chain of handlers<br>
 * 3. Pass the cron expression and master data map to the handlers<br>
 * 4. Print the output on console<br>
 */
public class CronExpressionParser {

    public static void main(String[] args) {
        String[] splittedValues = validateInput(args);
        if (splittedValues == null) {
            return;
        }
        try {
            Properties configuration = loadProperties();

            if (!isCronExpressionValid(splittedValues, configuration)) {
                System.err.println(INVALID_CRON_EXPRESSION);
                return;
            }

            SimpleValueHandler simpleValueHandler = new SimpleValueHandler(null);
            StepHandler stepHandler = new StepHandler(simpleValueHandler);
            RangeHandler rangeHandler = new RangeHandler(stepHandler);
            MultipleValuesHandler multipleValuesHandler = new MultipleValuesHandler(rangeHandler);
            ArbitValueHandler arbitValueHandler = new ArbitValueHandler(multipleValuesHandler);
            AnyValueHandler anyValueHandler = new AnyValueHandler(arbitValueHandler);

            Map<Integer, String[]> valuesMap = populateMasterData();

            GenericParser genericParser = new GenericParser(anyValueHandler, valuesMap);
            List<String> results = genericParser.parseCronExpression(splittedValues);

            for (Integer position : cronFieldPositions) {
                System.out.println(formatConsoleOutput(position, results.get(position)));
            }
            System.out.println(formatConsoleOutput(splittedValues.length - 1, splittedValues[splittedValues.length - 1]));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
