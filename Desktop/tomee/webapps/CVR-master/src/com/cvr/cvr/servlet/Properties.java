package com.cvr.cvr.servlet;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import com.cvr.cvr.application.CVR;
import org.apache.log4j.Logger;

/**
 * Created by Conno on 3/10/2016.
 */
@WebServlet(name = "PropertiesTest", urlPatterns = {"/properties-test"} )



public class Properties extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (getServletContext().getAttribute("properties") != null) {

            CVR cvr = (CVR) getServletContext().getAttribute("properties");
            log.info("success");

            req.setAttribute("count", cvr.propertyCount());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/properties" +
                ".jsp");
        dispatcher.forward(req, resp);

    }

}