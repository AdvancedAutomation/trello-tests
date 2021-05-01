package org.example.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for storage names.
 */
public final class ScenarioContext {

    private final Map<String, String> container;

    /**
     * Method for read the JSON file.
     */
    public ScenarioContext() {
        container = new HashMap<>();
    }

    /**
     * Setter of the user name.
     * @param key type String
     * @param value type String
     */
    public void setContext(final String key, final String value) {
        container.put(key, value);
    }

    /**
     * Getter of the user name.
     * @param key type String
     * @return the String of user.
     */
    public String getContext(final String key) {
        return container.get(key);
    }
}
