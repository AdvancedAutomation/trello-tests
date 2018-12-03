package org.fundacionjala.core;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
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
            BufferedReader br = new BufferedReader(new FileReader("environment.json"));
            JSONObject jsonObject = (JSONObject) parser.parse(br.readLine());
            usr = (String) jsonObject.get("user".concat(String.valueOf(numUser)));
            pwd = (String) jsonObject.get("pass".concat(String.valueOf(numUser)));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
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
