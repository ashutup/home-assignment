package com.deliveroo.assignment.handlers;

import com.deliveroo.assignment.exception.WrongOrderParsingException;

import java.util.List;

import static com.deliveroo.assignment.utils.Constants.HIPHEN;
import static com.deliveroo.assignment.utils.Constants.ORDER_NOT_CORRECT_WITH_HIPHEN;
import static com.deliveroo.assignment.utils.CronUtilities.*;

/**
 * Handles the fields for all possible values as per the range provided. Range is provide with the help of '-'
 * 1-10 means all numbers from 1 to 10
 */
public class RangeHandler extends Handler {

    public RangeHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public String handle(String fieldValue, List<String[]> listOfDataSet) {
        if (fieldValue.contains(HIPHEN)) {
            String[] splittedArr = fieldValue.split(HIPHEN);
            String[] dataSet = findApplicableDataSet(splittedArr[0], listOfDataSet);
            if (findIndexOfValueInArray(splittedArr[1], dataSet) < findIndexOfValueInArray(splittedArr[0], dataSet)) {
                throw new WrongOrderParsingException(String.format("%s=>%s", ORDER_NOT_CORRECT_WITH_HIPHEN, fieldValue));
            }
            return toString(fieldValue, dataSet);
        }
        return handleNext(fieldValue, listOfDataSet);
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
