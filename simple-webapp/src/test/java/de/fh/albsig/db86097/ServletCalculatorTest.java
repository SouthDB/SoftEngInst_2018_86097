package de.fh.albsig.db86097;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

public class ServletCalculatorTest {

	@Test
	public void ServletTestFibonacci() throws Exception {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		when(request.getParameter("mode")).thenReturn("fibonacci");
		when(request.getParameter("n")).thenReturn("6");

		StringWriter stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter);
		when(response.getWriter()).thenReturn(writer);

		new ServletCalculator().doPost(request, response);

		verify(request, times(1)).getParameter("mode");
		assertTrue(stringWriter.toString().contains("Result = 8"));
	}

}
