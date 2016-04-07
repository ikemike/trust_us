package com.cvr.cvr.servlet;

import com.cvr.cvr.application.CVR;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Conno on 3/30/2016.
 */

@WebServlet(name = "applicationStartup", urlPatterns = { "/startup" }, loadOnStartup = 1 )

public class ApplicationStartup extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());
    private Properties properties;

    /**
     * The method initializes the application loading Property file.
     * @throws ServletException
     */
    public void init() throws ServletException {
        loadProperties("/cvr.properties");
        ServletContext context = getServletContext();
        CVR cvr = new CVR(properties);
        context.setAttribute("properties", cvr);
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