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

    private String usr;
    private String pwd;

    /**
     * Constructor for the Environment.
     *
     * @param numUser Integer for select the user.
     */
    public Environment(int numUser) {
        JSONParser parser = new JSONParser();
        try (InputStream inputStream = new FileInputStream("environment.json");) {
            Reader fileReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            JSONObject jsonObject = (JSONObject) parser.parse(fileReader);
            usr = (String) jsonObject.get("user".concat(String.valueOf(numUser)));
            pwd = (String) jsonObject.get("pass".concat(String.valueOf(numUser)));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Getter of the user name.
     *
     * @return the String of user.
     */
    public String getUsr() {
        return usr;
    }

    /**
     * Getter of the password.
     *
     * @return the String of the password.
     */
    public String getPwd() {
        return pwd;
    }
}
