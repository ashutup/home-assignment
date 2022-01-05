package com.deliveroo.assignment.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.deliveroo.assignment.utils.Constants.*;

public class CronUtilities {

    /**
     * Load the key value pairs from properties file
     *
     * @return
     * @throws IOException
     */
    public static Properties loadProperties() throws IOException {
        Properties configuration = new Properties();
        InputStream inputStream = CronUtilities.class
                .getClassLoader()
                .getResourceAsStream("application.properties");
        configuration.load(inputStream);
        assert inputStream != null;
        inputStream.close();
        return configuration;
    }

    /**
     * Returns true if the strToMatch matches with the regex, else return false
     *
     * @param strToMatch
     * @param regex
     * @return
     */
    public static boolean match(String strToMatch, String regex) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(strToMatch);

        return matcher.matches();
    }

    /**
     * Formats and return the String to be printed on console
     *
     * @param index
     * @param data
     * @return
     */
    public static String formatConsoleOutput(int index, String data) {
        return String.format("%s%s", StringUtils.rightPad(HEADERS[index], HEADERS_PADDING_SIZE), data);
    }

    public static int findIndexOfValueInArray(String value, String[] arr) {
        int startIndex = 0;
        int i = 0;
        while (i < arr.length) {
            if (arr[i].equalsIgnoreCase(value)) {
                startIndex = i;
                break;
            }
            i++;
        }
        return startIndex;
    }

    /**
     * Returns string representation of array starting from startIndex, taking step at a time till endIndex.
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     * @param step       if step is 1 then all value from startIndex to endIndex. If step is 2 then start from startIndex and add 2 at a time till endIndex
     * @return
     */
    public static String stringifySubsetInArray(String[] arr, int startIndex, int endIndex, int step) {
        if (arr == null || startIndex > endIndex || step < 1) {
            return StringUtils.EMPTY;
        }

        StringBuilder buf = new StringBuilder();
        while (startIndex <= endIndex) {
            buf.append(arr[startIndex]).append(StringUtils.SPACE);
            startIndex = startIndex + step;
        }
        return buf.toString().trim();
    }

    /**
     * Populates the master data for all fields which is nothing but an array of all possibles values for each field
     *
     * @return Map containing master data of all fields
     */
    public static Map<Integer, String[]> populateMasterData() {

        Map<Integer, String[]> valuesMap = new HashMap<>();
        valuesMap.put(MINUTES_IDX, MINUTES);
        valuesMap.put(HOURS_IDX, HOURS);
        valuesMap.put(DAY_OF_MONTH_IDX, DAY_OF_MONTH);
        valuesMap.put(MONTH_IDX, MONTH);
        valuesMap.put(DAY_OF_WEEK_IDX, DAY_OF_WEEK);

        return valuesMap;
    }

}
