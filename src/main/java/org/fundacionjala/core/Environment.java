package org.fundacionjala.core;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

/**
 * Class for set the environment of the project.
 */
public class Environment {

    private String user;
    private String pass;
    private static final String USER_KEY = "user";
    private static final String PASS_KEY = "pass";
    private static final String CONF_FILE = "environment.json";
    private static final String USER_KEY_ = "user-";
    private static final String PASS_KEY_ = "pass-";
    private static String confFile = null;

    /**
     * Method for read the JSON file.
     *
     * @param numUser integer for select the user.
     */
    public void readJSONUser(int numUser) {
        JSONParser parser = new JSONParser();
        try (InputStream inputStream = new FileInputStream(CONF_FILE)) {
            Reader fileReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            JSONObject jsonObject = (JSONObject) parser.parse(fileReader);
            user = (String) jsonObject.get(USER_KEY.concat(String.valueOf(numUser)));
            pass = (String) jsonObject.get(PASS_KEY.concat(String.valueOf(numUser)));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for read the JSON file.
     *
     * @param key String for select the user.
     */
    public void readJSONUser(final String key) {
        String[] parts = key.split("\\.");
        confFile = parts[0].substring(1).concat(".json");
        String typeUser = parts[1].substring(0,parts[1].length()-1);
        JSONParser parser = new JSONParser();
        try (InputStream inputStream = new FileInputStream(confFile)) {
            Reader fileReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            JSONObject jsonObject = (JSONObject) parser.parse(fileReader);
            user = (String) jsonObject.get(USER_KEY_.concat(typeUser));
            pass = (String) jsonObject.get(PASS_KEY_.concat(typeUser));
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
