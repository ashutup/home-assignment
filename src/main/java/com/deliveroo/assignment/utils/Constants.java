package com.deliveroo.assignment.utils;

public class Constants {

    //properties strings
    public static final String REGEX_MINUTES = "regex.minutes";
    public static final String REGEX_HOURS = "regex.hours";
    public static final String REGEX_DAY_OF_MONTH = "regex.day.of.month";
    public static final String REGEX_MONTH = "regex.month";
    public static final String REGEX_DAY_OF_WEEK = "regex.day.of.week";

    //Special Characters Cron Values
    public static final String ASTERISK = "*";
    public static final String HIPHEN = "-";
    public static final String COMMA = ",";
    public static final String QUESTION_MARK = "?";
    public static final String FORWARD_SLASH = "/";

    //Values arrays for all cron fields
    public static final String[] MINUTES = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"};

    public static final String[] HOURS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};

    public static final String[] DAY_OF_MONTH = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};

    public static final String[] MONTH = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};

    public static final String[] DAY_OF_WEEK = {"0", "1", "2", "3", "4", "5", "6"};

    //Positions in cron expression
    public static final int MINUTES_IDX = 0;
    public static final int HOURS_IDX = 1;
    public static final int DAY_OF_MONTH_IDX = 2;
    public static final int MONTH_IDX = 3;
    public static final int DAY_OF_WEEK_IDX = 4;

    public static final int[] cronFieldPositions = {0, 1, 2, 3, 4};
    public static final String[] HEADERS = {"minute", "hour", "day of month", "month", "day of week", "command"};

    //String constants
    public static final String PARSING_ABILITY_NOT_EXISTS = "PARSING_ABILITY_NOT_EXISTS";
    public static final int HEADERS_PADDING_SIZE = 14;
    public static final int VALID_COUNT_OF_ARGUMENTS = 1;
    public static final int VALID_COUNT_OF_SPACE_SEPERATED_FIELDS = 6;
    public static final String ONE_OR_MORE_SPACES = "\\s+";
    public static final String HELP_EXAMPLE = "\nExample : java -jar <executable-jar-name> \"<minute> <hour> <day of month> <month> <day of week> <command>\"";

    //Error Messages
    public static final String ERROR_NO_ARGUMENT_PROVIDED = "Error : No Argument Provided";
    public static final String ERROR_MSG_MISSING_ARGUMENTS = "Error : Please provide valid arguments!!! Five fields for cron expression and one command";
    public static final String INVALID_CRON_EXPRESSION = "ERROR - INVALID CRON EXPRESSION : Please provide valid one";
    public static final String MINUTES_INVALID_ERROR_MSG = "INVALID : MINUTES";
    public static final String HOURS_INVALID_ERROR_MSG = "INVALID : HOURS";
    public static final String DAY_OF_MONTH_INVALID_ERROR_MSG = "INVALID : DAY OF MONTH";
    public static final String MONTH_INVALID_ERROR_MSG = "INVALID : MONTH";
    public static final String DAY_OF_WEEK_INVALID_ERROR_MSG = "INVALID : DAY OF WEEK";
    public static final String ORDER_NOT_CORRECT_WITH_HIPHEN = "Order of values separated by '-' is not correct";

}
