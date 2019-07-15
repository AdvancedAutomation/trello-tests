package org.fundacionjala.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for storage names.
 */
public final class ScenarioContext {
    private Map<String, String> container;
    private static ScenarioContext ourInstance;

    /**
     * Method for return the instance dof environment.
     * @return the our instance.
     */
    public static ScenarioContext getInstance() {
        if (ourInstance == null) {
            ourInstance = new ScenarioContext();
        }
        return ourInstance;
    }

    /**
     * Method for read the JSON file.
     */
    private ScenarioContext() {
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
