package com.cvr.cvr.application;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Vlad on 3/31/2016.
 */
@Path("/service")
public class Service {
    Properties properties;

    @GET
    @Path("/txt/{param}")
    @Produces("text/plain")
    public String getPlainMessage(@PathParam("param") String userInput) {
        // userInput contains the string that the program will transform to userOutput.
        // The transformation happens in CVR class.
        // This Service class receives the userOutput string and returns it as a plain text

        // In this example lets get a string from user and convert it to corresponding word
        // from glossary (properties file).
        loadProperties("/cvr.properties");
        CVR cvr = new CVR(properties);
        String userOutput = cvr.processString(userInput);
        return "CVR-I: " + userOutput;
    }

    /**
     * The method loads properties from the properties file.
     * @param propertiesFilePath path to properties file.
     * @exception IOException
     * @exception Exception
     */
    public void loadProperties(String propertiesFilePath) {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch(IOException ioException) {
            ioException.printStackTrace();
        } catch(Exception exception) {
            exception.printStackTrace();
        }
    }
}
