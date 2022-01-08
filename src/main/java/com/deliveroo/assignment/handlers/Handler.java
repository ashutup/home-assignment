package com.deliveroo.assignment.handlers;

import java.util.List;

import static com.deliveroo.assignment.utils.Constants.PARSING_ABILITY_NOT_EXISTS;

/**
 * Abstract handler which provides the template for type handler.
 */
public abstract class Handler {
    private Handler nextHandler;

    public Handler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    /**
     * Delegates to the next handler
     */
    public String handleNext(String fieldValue, List<String[]> listOfDataSet) {
        if (nextHandler != null)
            return nextHandler.handle(fieldValue, listOfDataSet);
        else
            return PARSING_ABILITY_NOT_EXISTS;
    }

    /**
     * Handles one field of cron expression and returns the elaborated string version for the same
     */
    public abstract String handle(String fieldValue, List<String[]> listOfDataSet);
}
