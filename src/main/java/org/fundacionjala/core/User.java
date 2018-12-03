package org.fundacionjala.core;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class User {

    private String usr;
    private String pwd;

    public User(int numUser) {
        JSONParser parser = new JSONParser();

        try {
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("/home/rocku/acc.json"));
            usr = (String) jsonObject.get("user".concat(String.valueOf(numUser)));
            pwd = (String) jsonObject.get("pass".concat(String.valueOf(numUser)));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public String getUsr() {
        return usr;
    }

    public String getPwd() {
        return pwd;
    }
}
