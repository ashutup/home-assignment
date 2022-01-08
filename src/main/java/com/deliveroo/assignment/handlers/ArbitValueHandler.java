package com.deliveroo.assignment.handlers;


import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static com.deliveroo.assignment.utils.Constants.QUESTION_MARK;

/**
 * Handles the fields for Arbit value which is denoted by '?' which means the field can be ignored.
 * This is applicable only for 'day of month' and 'day of week'
 */
public class ArbitValueHandler extends Handler {

    public ArbitValueHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public String handle(String fieldValue, List<String[]> listOfDataSet){
        if (fieldValue.equalsIgnoreCase(QUESTION_MARK)) {
            return StringUtils.EMPTY;
        }
        return handleNext(fieldValue, listOfDataSet);
    }
}
