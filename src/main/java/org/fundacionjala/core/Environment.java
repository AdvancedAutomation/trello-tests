package org.fundacionjala.core;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

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
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("/home/rocku/acc.json"));
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
