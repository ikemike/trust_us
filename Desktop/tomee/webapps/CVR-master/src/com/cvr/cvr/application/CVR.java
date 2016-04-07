package com.cvr.cvr.application;

import org.apache.log4j.Logger;

import java.util.Properties;

/**
 * Created by Conno on 3/30/2016.
 */
public class CVR {

    private final Logger log = Logger.getLogger(this.getClass());

    private Properties properties;

    public CVR() {

    }

    public CVR(Properties properties) {
        this();
        this.properties = properties;
    }

    public String processString(String string) {
        String[] tokens = createTokens(string);
        String translatedString = string;

        for (String token : tokens) {

            String newToken = checkToken(token);
            translatedString = translatedString.replace(token, newToken);
        }

        return translatedString;
    }



    /**
     *  Split each line of strings to put into separate elements in
     *  ArrayList.
     *
     *  @param string Line of strings from ASCII text file.
     */
    public String[] createTokens(String string) {
        String[] tokenArray = string.split("\\W");
        return tokenArray;
    }

    public String checkToken(String token) {
        if (properties.containsKey(token)) {
            token = properties.getProperty(token);
        }

        return token;
    }

    public int propertyCount() {
        return properties.size();
    }
}
