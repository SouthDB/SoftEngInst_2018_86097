package de.fh.albsig.db86097;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

public class ServletCalculator extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// read request Parameter
		String mode = request.getParameter("mode");
		String reqN = request.getParameter("n");

		int n = 0;
		long result = 0;
		String reqResult = null;

		// covert request Parameter
		try {
			n = Integer.parseInt(reqN);
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
			reqN = null;
		}

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

			if (result <= 0) { // result > range from long -> return 0
				reqResult = "Input Error";
			} else {
				reqResult = "Result = " + Long.toString(result);
			}
		} else {
			reqResult = "Parameter Error";
		}

		// Json Response
		Map<String, Object> forJsonObj = new HashMap<>();
		forJsonObj.put("result", reqResult);

		JSONObject jobj = new JSONObject(forJsonObj);

		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(jobj.toString());

		out.flush();
		out.close();

	}
}
