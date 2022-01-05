package com.deliveroo.assignment.validator;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Properties;

import static com.deliveroo.assignment.utils.Constants.*;
import static com.deliveroo.assignment.utils.CronUtilities.match;


public class ValidationUtils {

    public static boolean isCronExpressionValid(String[] args, Properties configuration) {

        if (!match(args[MINUTES_IDX], configuration.getProperty(REGEX_MINUTES))) {
            System.err.println(String.format("%s->%s", MINUTES_INVALID_ERROR_MSG, args[MINUTES_IDX]));
            return false;
        }

        if (!match(args[HOURS_IDX], configuration.getProperty(REGEX_HOURS))) {
            System.err.println(String.format("%s->%s", HOURS_INVALID_ERROR_MSG, args[HOURS_IDX]));
            return false;
        }

        if (!match(args[DAY_OF_MONTH_IDX], configuration.getProperty(REGEX_DAY_OF_MONTH))) {
            System.err.println(String.format("%s->%s", DAY_OF_MONTH_INVALID_ERROR_MSG, args[DAY_OF_MONTH_IDX]));
            return false;
        }

        if (!match(args[MONTH_IDX], configuration.getProperty(REGEX_MONTH))) {
            System.err.println(String.format("%s->%s", MONTH_INVALID_ERROR_MSG, args[MONTH_IDX]));
            return false;
        }

        if (!match(args[DAY_OF_WEEK_IDX], configuration.getProperty(REGEX_DAY_OF_WEEK))) {
            System.err.println(String.format("%s->%s", DAY_OF_WEEK_INVALID_ERROR_MSG, args[DAY_OF_WEEK_IDX]));
            return false;
        }

        return true;
    }

    public static String[] validateInput(String[] args) {

        if (ArrayUtils.isEmpty(args) || args.length != VALID_COUNT_OF_ARGUMENTS) {
            System.err.println(String.format("%s%s", ERROR_NO_ARGUMENT_PROVIDED, HELP_EXAMPLE));
            return null;
        }

        String[] inputArray = args[0].split(ONE_OR_MORE_SPACES);

        if (inputArray.length != VALID_COUNT_OF_SPACE_SEPERATED_FIELDS) {
            System.err.println(String.format("%s%s", ERROR_MSG_MISSING_ARGUMENTS, HELP_EXAMPLE));
            return null;
        }

        return inputArray;
    }

}
