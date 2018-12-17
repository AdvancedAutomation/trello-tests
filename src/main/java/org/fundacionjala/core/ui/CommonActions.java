package org.fundacionjala.core.ui;

import java.time.LocalDateTime;

/**
 * this class represented a action page.
 */
public class CommonActions {

    private static final String DATE_TIME = "dateTime";

    /**
     * Method for remove characters .{} .
     * @param textInBrackets type String.
     * @return value of type String[].
     */
    public String[] getUserFromKey(final String textInBrackets) {
        String[] parts = textInBrackets.split("[\\{\\.\\}]+");
        parts[2] = parts[1].equals(DATE_TIME) ? parts[2].concat(LocalDateTime.now().toString()) : parts[2];
        return new String[]{parts[1], parts[2]};
    }
}
