package com.deliveroo.assignment.handlers;

import static com.deliveroo.assignment.utils.Constants.*;

/**
 * When there is no special handling required for a field value, just accept the value as it is.
 */
public class SimpleValueHandler extends Handler {

    public SimpleValueHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public String handle(String fieldValue, String[] array) {
        if (!fieldValue.contains(ASTERISK)
                && !fieldValue.contains(HIPHEN)
                && !fieldValue.contains(COMMA)
                && !fieldValue.contains(QUESTION_MARK)
                && !fieldValue.contains(FORWARD_SLASH))
            return fieldValue;

        return handleNext(fieldValue, array);
    }
}
