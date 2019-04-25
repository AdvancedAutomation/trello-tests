package org.fundacionjala.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for storage names.
 */
public final class NamesStorage {
    private Map<String, String> container;
    private static NamesStorage ourInstance;

    /**
     * Method for return the instance dof environment.
     * @return the our instance.
     */
    public static NamesStorage getInstance() {
        if (ourInstance == null) {
            ourInstance = new NamesStorage();
        }
        return ourInstance;
    }

    /**
     * Method for read the JSON file.
     */
    private NamesStorage() {
        container = new HashMap<>();
    }

    /**
     * Setter of the user name.
     * @param key type String
     * @param value type String
     */
    public void addName(final String key, final String value) {
        container.put(key, value);
    }

    /**
     * Getter of the user name.
     * @param key type String
     * @return the String of user.
     */
    public String getName(final String key) {
        return container.get(key);
    }
}
