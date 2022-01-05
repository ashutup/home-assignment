package com.deliveroo.assignment.handlers;

import org.apache.commons.lang3.StringUtils;

import static com.deliveroo.assignment.utils.Constants.COMMA;

/**
 * Handles the fields for multiple values which are separated by ','
 */
public class MultipleValuesHandler extends Handler {

    public MultipleValuesHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public String handle(String fieldValue, String[] array) {
        if (fieldValue.contains(COMMA)) {
            return toString(fieldValue, array);
        }
        return handleNext(fieldValue, array);
    }

    private String toString(String fieldValue, String[] arr) {
        String[] values = fieldValue.split(COMMA);

        StringBuilder buffer = new StringBuilder();
        for (String val : values) {
            buffer.append(val).append(StringUtils.SPACE);
        }
        return buffer.toString().trim();

    }
}
