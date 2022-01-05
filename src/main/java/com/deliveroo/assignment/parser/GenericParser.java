package com.deliveroo.assignment.parser;

import com.deliveroo.assignment.handlers.Handler;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.deliveroo.assignment.utils.Constants.cronFieldPositions;

/**
 * Parses the cron expression fields with Chain of handlers.
 */
public class GenericParser {

    private Handler genericHandlerChain;
    private Map<Integer, String[]> masterData;

    public GenericParser(Handler genericHandlerChain, Map<Integer, String[]> masterData) {
        this.genericHandlerChain = genericHandlerChain;
        this.masterData = masterData;
    }

    public List<String> parseCronExpression(String[] arr) {
        List<String> result = new LinkedList<>();
        for (Integer position : cronFieldPositions) {
            result.add(genericHandlerChain.handle(arr[position], masterData.get(position)));
        }
        return result;
    }
}
