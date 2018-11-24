package de.fh.albsig.db86097;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

/** Servlet to handle requests for Calculator. */

public class ServletCalculator extends HttpServlet {

    /** Logger for Exceptions. */
    static final Logger LOGGER = Logger.getLogger(HttpServlet.class);

    /** HTTP Server Based Error. */
    public static final int SERVER_BASED = 500;

    /**
     * handle post request for Calculator and start fibonacci or PowerOfTwo
     * mode.
     * 
     * @param request  include mode and n from client
     * @param response send result or calculate error to client
     * @throws ServletException Servlet error for client
     * @throws IOException      failed or interrupted I/O operations
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // read request Parameter
        String mode = request.getParameter("mode");
        String reqN = request.getParameter("n");

        boolean numberContain = StringUtils.containsOnly(reqN, '1', '2', '3',
                '4', '5', '6', '7', '8', '9', '0');

        int n = 0;
        long result = 0;
        String reqResult = null;

        // convert request Parameter
        if (numberContain) {
            try {
                n = Integer.parseInt(reqN);
            } catch (NumberFormatException nfe) {
                LOGGER.error("Parse client variable n goes wrong", nfe);
                reqN = null;
            }
        }

        try {
            // start calculator mode
            if (mode.equals("fibonacci") && reqN != null) {
                Fibonacci fib = new Fibonacci();
                result = fib.fibonacci(n);

                if (result < 0) {
                    reqResult = "Input Error";
                } else {
                    reqResult = "Result = " + Long.toString(result);
                }
            } else if (mode.equals("powTwo") && reqN != null) {
                PowerOfTwo pt = new PowerOfTwo();
                result = pt.powTwo(n);

                if (result < 0) {
                    reqResult = "Input Error";
                } else {
                    reqResult = "Result = " + Long.toString(result);
                }
            } else {
                reqResult = "Parameter Error";
            }
        } catch (Exception ex) {
            LOGGER.error("Calculate mode goes wrong", ex);
            response.sendError(SERVER_BASED);
        }

        // Json Response
        try {
            Map<String, Object> forJsonObj = new HashMap<>();
            forJsonObj.put("result", reqResult);
            JSONObject jobj = new JSONObject(forJsonObj);

            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write(jobj.toString());

            out.flush();
            out.close();
        } catch (Exception ex) {
            LOGGER.error("JSON Response goes wrong", ex);
            response.sendError(SERVER_BASED);
        }

    }
}
