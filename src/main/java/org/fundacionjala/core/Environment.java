package org.fundacionjala.core;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Singleton Class of environment.
 */
public final class Environment {

    private static final String CONF_FILE = "environment.json";
    private static Environment ourInstance;
    private DocumentContext jsonContext;

    /**
     * Method for return the instance dof environment.
     * @return the our instance.
     */
    public static Environment getInstance() {
        if (ourInstance == null) {
            ourInstance = new Environment();
        }
        return ourInstance;
    }

    /**
     * Method for read the JSON file.
     */
    private Environment() {
        JSONParser parser = new JSONParser();
        try (InputStream inputStream = new FileInputStream(CONF_FILE)) {
            Reader fileReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            JSONObject jsonObject = (JSONObject) parser.parse(fileReader);
            jsonContext = JsonPath.parse(jsonObject);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Getter of the user name.
     * @param key type String
     * @return the String of user.
     */
    public String getValue(final String key) {
        return  jsonContext.read(key);
    }
}
