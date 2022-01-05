package com.deliveroo.assignment.handlers;

import org.apache.commons.lang3.StringUtils;

import static com.deliveroo.assignment.utils.Constants.ASTERISK;

/**
 * Handles the fields for all possible values related. All possible values are denoted by '*'
 */
public class AnyValueHandler extends Handler {

    public AnyValueHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public String handle(String fieldValue, String[] array) {
        if (fieldValue.equalsIgnoreCase(ASTERISK)) {
            return toString(array);
        }
        return handleNext(fieldValue, array);
    }

    private String toString(String[] arr) {
        StringBuilder buffer = new StringBuilder();
        for (String str : arr) {
            buffer.append(str).append(StringUtils.SPACE);
        }
        return buffer.toString().trim();

    }
}
