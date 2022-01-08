package com.deliveroo.assignment.handlers;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static com.deliveroo.assignment.utils.Constants.ASTERISK;
import static com.deliveroo.assignment.utils.Constants.POSITION_OF_DEFAULT_DATASET;

/**
 * Handles the fields for all possible values related. All possible values are denoted by '*'
 */
public class AnyValueHandler extends Handler {

    public AnyValueHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public String handle(String fieldValue, List<String[]> listOfDataSet) {
        if (fieldValue.equalsIgnoreCase(ASTERISK)) {
            return toString(listOfDataSet.get(POSITION_OF_DEFAULT_DATASET));
        }
        return handleNext(fieldValue, listOfDataSet);
    }

    private String toString(String[] arr) {
        StringBuilder buffer = new StringBuilder();
        for (String str : arr) {
            buffer.append(str).append(StringUtils.SPACE);
        }
        return buffer.toString().trim();
    }
}
