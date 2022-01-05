package com.deliveroo.assignment.handlers;

import static com.deliveroo.assignment.utils.Constants.ASTERISK;
import static com.deliveroo.assignment.utils.Constants.FORWARD_SLASH;
import static com.deliveroo.assignment.utils.CronUtilities.findIndexOfValueInArray;
import static com.deliveroo.assignment.utils.CronUtilities.stringifySubsetInArray;

/**
 * Handles the fields for all possible values related.
 * 1/5 for minutes field means, starting from 1, all possible minute values by adding 5 everytime.
 * 1/5 : 1, 6, 11, 16, 21, 26, 31 so on .. till less than or equal to 59
 */
public class StepHandler extends Handler {

    public StepHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public String handle(String fieldValue, String[] arr) {
        if (fieldValue.contains(FORWARD_SLASH)) {
            return toString(fieldValue, arr);
        }

        return handleNext(fieldValue, arr);
    }

    private String toString(String fieldValue, String[] arr) {
        String[] splittedValues = fieldValue.split(FORWARD_SLASH);
        int step = Integer.parseInt(splittedValues[1]);
        int startIndex = -1;
        int endIndex = arr.length - 1;

        if (fieldValue.startsWith(ASTERISK)) {
            startIndex = 0;
        } else {
            String startingValue = splittedValues[0];
            startIndex = findIndexOfValueInArray(startingValue, arr);
        }

        return stringifySubsetInArray(arr, startIndex, endIndex, step);

    }
}
