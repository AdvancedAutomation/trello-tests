package org.fundacionjala.core;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Environment {

    private String user;
    private String pass;
    private String credentials = "$['credentials']['";
    private static final String CONF_FILE = "environment.json";

    private static Environment ourInstance;

    /**
     * Method for return the instance dof environment.
     * @return the our instance.
     */
    public static Environment getInstance(final String key) {
        if (ourInstance == null){
            ourInstance = new Environment(key);
        }
        return ourInstance;
    }

    /**
     * Method for read the JSON file.
     *
     * @param key String for select the user.
     */
    private Environment(final String key) {
        JSONParser parser = new JSONParser();
        try (InputStream inputStream = new FileInputStream(CONF_FILE)) {
            Reader fileReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            JSONObject jsonObject = (JSONObject) parser.parse(fileReader);
            DocumentContext jsonContext = JsonPath.parse(jsonObject);
            user = jsonContext.read(credentials.concat(key).concat("']['username']"));
            pass = jsonContext.read(credentials.concat(key).concat("']['password']"));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Getter of the user name.
     *
     * @return the String of user.
     */
    public String getUser() {
        return user;
    }

    /**
     * Getter of the password.
     *
     * @return the String of the password.
     */
    public String getPass() {
        return pass;
    }
}
