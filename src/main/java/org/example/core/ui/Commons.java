package org.example.core.ui;

import java.time.LocalDateTime;

/**
 * this class represented a action page.
 */
public final class Commons {

    private static final String DATE_TIME = "dateTime";

    /**
     * Method constructor.
     */
    private Commons() {
    }

    /**
     * Method for remove characters .{} .
     * @param textInBrackets type String.
     * @return value of type String[].
     */
    public static String getUserFromKey(final String textInBrackets) {
        String[] parts = textInBrackets.split("[\\{\\.\\}]+");
        parts[2] = parts[1].equals(DATE_TIME) ? parts[2].concat(LocalDateTime.now().toString()) : parts[2];
        return parts[2];
    }
}
