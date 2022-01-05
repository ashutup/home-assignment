package com.deliveroo.assignment.handlers;

import com.deliveroo.assignment.exception.WrongOrderParsingException;

import static com.deliveroo.assignment.utils.Constants.HIPHEN;
import static com.deliveroo.assignment.utils.Constants.ORDER_NOT_CORRECT_WITH_HIPHEN;
import static com.deliveroo.assignment.utils.CronUtilities.findIndexOfValueInArray;
import static com.deliveroo.assignment.utils.CronUtilities.stringifySubsetInArray;

/**
 * Handles the fields for all possible values as per the range provided. Range is provide with the help of '-'
 * 1-10 means all numbers from 1 to 10
 */
public class RangeHandler extends Handler {

    public RangeHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public String handle(String fieldValue, String[] array) {
        if (fieldValue.contains(HIPHEN)) {
            String[] splittedArr = fieldValue.split(HIPHEN);
            if (findIndexOfValueInArray(splittedArr[1], array) < findIndexOfValueInArray(splittedArr[0], array)) {
                throw new WrongOrderParsingException(String.format("%s=>%s", ORDER_NOT_CORRECT_WITH_HIPHEN, fieldValue));
            }
            return toString(fieldValue, array);
        }

        return handleNext(fieldValue, array);
    }

    private String toString(String fieldValue, String[] arr) {
        String[] values = fieldValue.split(HIPHEN);
        String start = values[0];
        String end = values[1];

        int startIndex = findIndexOfValueInArray(start, arr);
        int endIndex = findIndexOfValueInArray(end, arr);

        return stringifySubsetInArray(arr, startIndex, endIndex, 1);

    }
}
