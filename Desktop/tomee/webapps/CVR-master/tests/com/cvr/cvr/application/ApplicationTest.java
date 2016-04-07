package com.cvr.cvr.application;
        import org.apache.log4j.Logger;
        import org.junit.Test;

        import javax.servlet.ServletContext;
        import javax.servlet.ServletException;
        import java.io.IOException;
        import java.util.Properties;

        import static org.junit.Assert.*;

/**
 * Created by Conno on 3/13/2016.
 */
public class ApplicationTest {

    private final Logger log = Logger.getLogger(this.getClass());

    Properties properties;

    @Test
    public void testTokens() throws Exception {
        loadProperties("/cvr.properties");
        CVR cvr = new CVR(properties);
        String token = "equipment";
        token = cvr.checkToken(token);
        assertTrue(token.equals("airplane"));
    }

    @Test
    public void stringTest() throws Exception {
        loadProperties("/cvr.properties");
        CVR cvr = new CVR(properties);
        String string = "equipment's, test. ramp";
        string = cvr.processString(string);
        log.info(string);
        assertTrue(string.equals("airplane's, test. aircraft parking zone"));

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
